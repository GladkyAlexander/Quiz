package ru.great_larder.sportquiz.services.load;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.Toast;
import ru.great_larder.sportquiz.MainActivity;
import ru.great_larder.sportquiz.database.GetListAuthorExternalDB;
import ru.great_larder.sportquiz.database.GetListCompanyPartnersExternalDB;
import ru.great_larder.sportquiz.database.mysql.GetListQuestionMySQL;
import ru.great_larder.sportquiz.database.mysql.request_get_mysql.*;
import ru.great_larder.sportquiz.database.repository.get_live.*;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.*;
import ru.great_larder.sportquiz.domain.*;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class LoadDataFromMySQLForSQLite {
	private User user;
	private Context context;
	private ProgressBar progressBar;
	
	public void load(User user, Context context, ProgressBar progressBar) {
		this.context = context;
		this.user = user;
		this.progressBar = progressBar;
		progressBar.setIndeterminate(true);
		Single.fromCallable(this::load).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
				.subscribe(this::update);
		
	}
	private void update(boolean a){
		progressBar.setProgress(100);
		((MainActivity)context).setFairies();
		System.out.println("Load external questions and author, and company data ok!");
		Toast.makeText(context, "Вопросы успешно обновлены!", Toast.LENGTH_SHORT).show();
	}
	private boolean load(){
/* --- School start ---------------------------------------------------------------------------------------------- 0 -*/
		progressBar.setIndeterminate(false);
		GetListQuestionMySQL getListBiologyQuestion = new GetListBiologyQuestionMySQLImpl();
		List<QuestionBiology> list = new ArrayList<>();
		List<Question> biologies = getListBiologyQuestion.getListQuestion(user, context);
		for (Question q : biologies) {
			list.add((QuestionBiology) q);
		}
		progressBar.setProgress(2);
		System.out.println("External biology end");
		ListBiologyLoad.setQuestionList(list);
		BiologyAdapterSQLite biologyAdapterSQLite = new BiologyAdapterSQLite(context);
		biologyAdapterSQLite.open();
		biologyAdapterSQLite.clearTable();
		biologyAdapterSQLite.setList(list);
		biologyAdapterSQLite.close();
		progressBar.setProgress(4);
		System.out.println("Local biology end");
		/*------------------------------------------------------------------------------------ 1 -*/
		GetListQuestionMySQL getListSocialStudies = new GetListSocialStudiesQuestionMySQLImpl();
		List<QuestionSocialStudies> listSocialStudies = new ArrayList<>();
		for (Question q : getListSocialStudies.getListQuestion(user, context)) {
			listSocialStudies.add((QuestionSocialStudies) q);
		}
		progressBar.setProgress(6);
		System.out.println("External SocialStudies end");
		ListSocialStudiesLoad.setQuestionList(listSocialStudies);
		SocialStudiesAdapterSQLite socialStudiesAdapterSQLite = new SocialStudiesAdapterSQLite(context);
		socialStudiesAdapterSQLite.open();
		socialStudiesAdapterSQLite.clearTable();
		socialStudiesAdapterSQLite.setList(listSocialStudies);
		socialStudiesAdapterSQLite.close();
		progressBar.setProgress(8);
		System.out.println("Local SocialStudies end");
		/*------------------------------------------------------------------------------------ 2 -*/
		GetListQuestionMySQL getListMathematicsQuestion = new GetListMathematicsQuestionMySQLImpl();
		List<QuestionMathematics> listMathematics = new ArrayList<>();
		List<Question> mathematics = getListMathematicsQuestion.getListQuestion(user, context);
		for (Question q : mathematics) {
			listMathematics.add((QuestionMathematics) q);
		}
		progressBar.setProgress(10);
		System.out.println("External Mathematics end");
		ListMathematicsLoad.setQuestionList(listMathematics);
		MathematicsAdapterSQLite mathematicsAdapterSQLite = new MathematicsAdapterSQLite(context);
		mathematicsAdapterSQLite.open();
		mathematicsAdapterSQLite.clearTable();
		mathematicsAdapterSQLite.setList(listMathematics);
		mathematicsAdapterSQLite.close();
		progressBar.setProgress(12);
		System.out.println("Local Mathematics end");
		/*------------------------------------------------------------------------------------- 3 -*/
		GetListQuestionMySQL getListPhysicsQuestion = new GetListPhysicsQuestionMySQLImpl();
		List<QuestionPhysics> listPhysics = new ArrayList<>();
		List<Question> physics = getListPhysicsQuestion.getListQuestion(user, context);
		for (Question q : physics) {
			listPhysics.add((QuestionPhysics) q);
		}
		progressBar.setProgress(14);
		System.out.println("External Physics end");
		ListPhysicsLoad.setQuestionList(listPhysics);
		PhysicsAdapterSQLite physicsAdapterSQLite = new PhysicsAdapterSQLite(context);
		physicsAdapterSQLite.open();
		physicsAdapterSQLite.clearTable();
		physicsAdapterSQLite.setList(listPhysics);
		physicsAdapterSQLite.close();
		progressBar.setProgress(16);
		System.out.println("Local Physics end");
		/*------------------------------------------------------------------------------------ 4 -*/
		GetListQuestionMySQL getListGeographyQuestion = new GetListGeographyQuestionMySQLImpl();
		List<QuestionGeography> listGeographyQuestion = new ArrayList<>();
		for (Question q : getListGeographyQuestion.getListQuestion(user, context)) {
			listGeographyQuestion.add((QuestionGeography) q);
		}
		progressBar.setProgress(18);
		System.out.println("External Geography end");
		ListGeographyLoad.setQuestionList(listGeographyQuestion);
		GeographyAdapterSQLite geographyAdapterSQLite = new GeographyAdapterSQLite(context);
		geographyAdapterSQLite.open();
		geographyAdapterSQLite.clearTable();
		geographyAdapterSQLite.setList(listGeographyQuestion);
		geographyAdapterSQLite.close();
		progressBar.setProgress(20);
		System.out.println("Local Geography end");
		/*------------------------------------------------------------------------------------ 5 -*/
		GetListQuestionMySQL getListHistoryQuestionMySQL = new GetListHistoryQuestionMySQLImpl();
		List<QuestionHistory> listHistory = new ArrayList<>();
		List<Question> histories = getListHistoryQuestionMySQL.getListQuestion(user, context);
		for (Question q : histories) {
			listHistory.add((QuestionHistory) q);
		}
		progressBar.setProgress(22);
		System.out.println("External History end");
		ListHistoryLoad.setQuestionList(listHistory);
		HistoryAdapterSQLite historyAdapterSQLite = new HistoryAdapterSQLite(context);
		historyAdapterSQLite.open();
		historyAdapterSQLite.clearTable();
		historyAdapterSQLite.setList(listHistory);
		historyAdapterSQLite.close();
		progressBar.setProgress(24);
		System.out.println("Local History end");
/* --- School ent ------------------------------------------------------------------------------------------------ 6 -*/
/* --- Etiquette start ------------------------------------------------------------------------------------------- 6 -*/
		GetListQuestionMySQL getListEtiquetteSecular = new GetListEtiquetteSecularQuestionMySQLImpl();
		List<QuestionEtiquetteSecular> listEtiquetteSecular = new ArrayList<>();
		for (Question q : getListEtiquetteSecular.getListQuestion(user, context)) {
			listEtiquetteSecular.add((QuestionEtiquetteSecular) q);
		}
		progressBar.setProgress(26);
		System.out.println("External Etiquette end");
		ListEtiquetteSecularLoad.setQuestionList(listEtiquetteSecular);
		EtiquetteSecularAdapterSQLite etiquetteSecularAdapterSQLite = new EtiquetteSecularAdapterSQLite(context);
		etiquetteSecularAdapterSQLite.open();
		etiquetteSecularAdapterSQLite.clearTable();
		etiquetteSecularAdapterSQLite.setList(listEtiquetteSecular);
		etiquetteSecularAdapterSQLite.close();
		progressBar.setProgress(28);
		System.out.println("Local Etiquette end");
		/*------------------------------------------------------------------------------------- 7-- -*/
		GetListQuestionMySQL getListEtiquetteBusinessQuestionMySQL = new GetListEtiquetteBusinessQuestionMySQLImpl();
		List<QuestionEtiquetteBusiness> listEtiquetteBusiness = new ArrayList<>();
		for (Question q : getListEtiquetteBusinessQuestionMySQL.getListQuestion(user, context)) {
			listEtiquetteBusiness.add((QuestionEtiquetteBusiness) q);
		}
		progressBar.setProgress(30);
		System.out.println("External Business end");
		ListEtiquetteBusinessLoad.setQuestionList(listEtiquetteBusiness);
		EtiquetteBusinessAdapterSQLite etiquetteBusinessAdapterSQLite = new EtiquetteBusinessAdapterSQLite(context);
		etiquetteBusinessAdapterSQLite.open();
		etiquetteBusinessAdapterSQLite.clearTable();
		etiquetteBusinessAdapterSQLite.setList(listEtiquetteBusiness);
		etiquetteBusinessAdapterSQLite.close();
		progressBar.setProgress(32);
		System.out.println("Local Business end");
/* --- Etiquette end --------------------------------------------------------------------------------------------- 8 -*/
/* --- Language start -------------------------------------------------------------------------------------------- 8 -*/
		GetListQuestionMySQL getListEnLanguageQuestion = new GetListLanguageEnQuestionMySQLImpl();
		List<QuestionEnLanguage> listEnLanguage = new ArrayList<>();
		List<Question> enLanguages = getListEnLanguageQuestion.getListQuestion(user, context);
		for (Question q : enLanguages) {
			listEnLanguage.add((QuestionEnLanguage) q);
		}
		progressBar.setProgress(34);
		System.out.println("External EnLanguage end");
		ListEnLanguageLoad.setQuestionList(listEnLanguage);
		LanguageEnAdapterSQLite languageEnAdapterSQLite = new LanguageEnAdapterSQLite(context);
		languageEnAdapterSQLite.open();
		languageEnAdapterSQLite.clearTable();
		languageEnAdapterSQLite.setList(listEnLanguage);
		languageEnAdapterSQLite.close();
		progressBar.setProgress(36);
		System.out.println("Local EnLanguage end");
		/*------------------------------------------------------------------------------------- 9 -*/
		GetListQuestionMySQL getListRuLanguage = new GetListLanguageRuQuestionMySQLImpl();
		List<QuestionRuLanguage> listRuLanguage = new ArrayList<>();
		List<Question> ruLanguages = getListRuLanguage.getListQuestion(user, context);
		for (Question q : ruLanguages) {
			listRuLanguage.add((QuestionRuLanguage) q);
		}
		progressBar.setProgress(38);
		System.out.println("External RuLanguage end");
		ListRuLanguageLoad.setQuestionList(listRuLanguage);
		LanguageRuAdapterSQLite languageRuAdapterSQLite = new LanguageRuAdapterSQLite(context);
		languageRuAdapterSQLite.open();
		languageRuAdapterSQLite.clearTable();
		languageRuAdapterSQLite.setList(listRuLanguage);
		languageRuAdapterSQLite.close();
		progressBar.setProgress(40);
		System.out.println("Local RuLanguage end");
		/*------------------------------------------------------------------------------------- 10 -*/
		GetListQuestionMySQL getListBashkirLanguage = new GetListBashkirLanguageQuestionMySQLImpl();
		List<QuestionBashkirLanguage> listBashkirLanguage = new ArrayList<>();
		List<Question> bashkirLanguages = getListBashkirLanguage.getListQuestion(user, context);
		for (Question q : bashkirLanguages) {
			listBashkirLanguage.add((QuestionBashkirLanguage) q);
		}
		System.out.println("External Bashkir Language end");
		progressBar.setProgress(42);
		ListBashkirLanguageLoad.setQuestionList(listBashkirLanguage);
		LanguageBashkirAdapterSQLite bashkirLanguageAdapterSQLite = new LanguageBashkirAdapterSQLite(context);
		bashkirLanguageAdapterSQLite.open();
		bashkirLanguageAdapterSQLite.clearTable();
		bashkirLanguageAdapterSQLite.setList(listBashkirLanguage);
		bashkirLanguageAdapterSQLite.close();
		progressBar.setProgress(44);
		System.out.println("Local Bashkir Language end");
		/*------------------------------------------------------------------------------------- 11 -*/
		GetListQuestionMySQL getListChuvashLanguage = new GetListChuvashLanguageQuestionMySQLImpl();
		List<QuestionChuvashLanguage> listChuvashLanguage = new ArrayList<>();
		List<Question> chuvashLanguages = getListChuvashLanguage.getListQuestion(user, context);
		for (Question q : chuvashLanguages) {
			listChuvashLanguage.add((QuestionChuvashLanguage) q);
		}
		System.out.println("External Chuvash Language end");
		progressBar.setProgress(46);
		ListChuvashLanguageLoad.setQuestionList(listChuvashLanguage);
		LanguageChuvashAdapterSQLite chuvashLanguageAdapterSQLite = new LanguageChuvashAdapterSQLite(context);
		chuvashLanguageAdapterSQLite.open();
		chuvashLanguageAdapterSQLite.clearTable();
		chuvashLanguageAdapterSQLite.setList(listChuvashLanguage);
		chuvashLanguageAdapterSQLite.close();
		progressBar.setProgress(48);
		System.out.println("Local Chuvash Language end");
		/*------------------------------------------------------------------------------------- 12 -*/
		GetListQuestionMySQL getListLanguageChechen = new GetListLanguageChechenQuestionMySQLImpl();
		List<QuestionChechenLanguage> listChechenLanguage = new ArrayList<>();
		List<Question> chechenLanguages = getListLanguageChechen.getListQuestion(user, context);
		for (Question q : chechenLanguages) {
			listChechenLanguage.add((QuestionChechenLanguage) q);
		}
		System.out.println("External Chechen Language end");
		progressBar.setProgress(50);
		ListChechenLanguageLoad.setQuestionList(listChechenLanguage);
		LanguageChechenAdapterSQLite chechenLanguageAdapterSQLite = new LanguageChechenAdapterSQLite(context);
		chechenLanguageAdapterSQLite.open();
		chechenLanguageAdapterSQLite.clearTable();
		chechenLanguageAdapterSQLite.setList(listChechenLanguage);
		chechenLanguageAdapterSQLite.close();
		progressBar.setProgress(52);
		System.out.println("Local Chechen Language end");
		/*------------------------------------------------------------------------------------- 13 -*/
		GetListQuestionMySQL getListTatarLanguage = new GetListLanguageTatarQuestionMySQLImpl();
		List<QuestionTatarLanguage> listTatarLanguage = new ArrayList<>();
		List<Question> tatarLanguages = getListTatarLanguage.getListQuestion(user, context);
		for (Question q : tatarLanguages) {
			listTatarLanguage.add((QuestionTatarLanguage) q);
		}
		System.out.println("External Tatar Language end");
		progressBar.setProgress(54);
		ListTatarLanguageLoad.setQuestionList(listTatarLanguage);
		LanguageTatarAdapterSQLite tatarLanguageAdapterSQLite = new LanguageTatarAdapterSQLite(context);
		tatarLanguageAdapterSQLite.open();
		tatarLanguageAdapterSQLite.clearTable();
		tatarLanguageAdapterSQLite.setList(listTatarLanguage);
		tatarLanguageAdapterSQLite.close();
		progressBar.setProgress(56);
		System.out.println("Local Tatar Language end");
/* --- Language end -------------------------------------------------------------------------------------------- 14 --*/
/* --- Sport start --------------------------------------------------------------------------------------------- 14 --*/
		GetListQuestionMySQL getListSportsQuestion = new GetListSportsQuestionMySQLImpl();
		List<QuestionSports> listSports = new ArrayList<>();
		List<Question> sports = getListSportsQuestion.getListQuestion(user, context);
		for (Question q : sports) {
			listSports.add((QuestionSports) q);
		}
		progressBar.setProgress(58);
		System.out.println("External Sports end");
		ListSportsLoad.setQuestionList(listSports);
		SportsAdapterSQLite sportsAdapterSQLite = new SportsAdapterSQLite(context);
		sportsAdapterSQLite.open();
		sportsAdapterSQLite.clearTable();
		sportsAdapterSQLite.setList(listSports);
		sportsAdapterSQLite.close();
		progressBar.setProgress(60);
		System.out.println("Local Sports end");
/* --- Sport end ----------------------------------------------------------------------------------------------- 15 --*/
/* --- Transport start ----------------------------------------------------------------------------------------- 15 --*/
		GetListQuestionMySQL getListAviationTransport = new GetListAviationTransportQuestionMySQLImpl();
		List<QuestionAviationTransport> listAviationTransport = new ArrayList<>();
		List<Question> aviationTransport = getListAviationTransport.getListQuestion(user, context);
		for (Question q : aviationTransport) {
			listAviationTransport.add((QuestionAviationTransport) q);
		}
		progressBar.setProgress(62);
		System.out.println("External Aviation transport end");
		ListAviationTransportLoad.setQuestionList(listAviationTransport);
		AviationTransportAdapterSQLite aviationTransportAdapterSQLite = new AviationTransportAdapterSQLite(context);
		aviationTransportAdapterSQLite.open();
		aviationTransportAdapterSQLite.clearTable();
		aviationTransportAdapterSQLite.setList(listAviationTransport);
		aviationTransportAdapterSQLite.close();
		progressBar.setProgress(64);
		System.out.println("Local Aviation transport end");
		/*------------------------------------------------------------------------------------- 16 -*/
		GetListQuestionMySQL getListRailwayTransport = new GetListRailwayTransportQuestionMySQLImpl();
		List<QuestionRailwayTransport> listRailwayTransport = new ArrayList<>();
		List<Question> railwayTransport = getListRailwayTransport.getListQuestion(user, context);
		for (Question q : railwayTransport) {
			listRailwayTransport.add((QuestionRailwayTransport) q);
		}
		progressBar.setProgress(66);
		System.out.println("External Railway Transport end");
		ListRailwayTransportLoad.setQuestionList(listRailwayTransport);
		RailwayTransportAdapterSQLite railwayTransportAdapterSQLite = new RailwayTransportAdapterSQLite(context);
		railwayTransportAdapterSQLite.open();
		railwayTransportAdapterSQLite.clearTable();
		railwayTransportAdapterSQLite.setList(listRailwayTransport);
		railwayTransportAdapterSQLite.close();
		progressBar.setProgress(68);
		System.out.println("Local Railway Transport end");
		/*------------------------------------------------------------------------------------- 17 -*/
		GetListQuestionMySQL getListRoadTransport = new GetListRoadTransportQuestionMySQLImpl();
		List<QuestionRoadTransport> listRoadTransport = new ArrayList<>();
		List<Question> roadTransport = getListRoadTransport.getListQuestion(user, context);
		for (Question q : roadTransport) {
			listRoadTransport.add((QuestionRoadTransport) q);
		}
		progressBar.setProgress(70);
		System.out.println("External Road Transport end");
		ListRoadTransportLoad.setQuestionList(listRoadTransport);
		RoadTransportAdapterSQLite roadTransportAdapterSQLite = new RoadTransportAdapterSQLite(context);
		roadTransportAdapterSQLite.open();
		roadTransportAdapterSQLite.clearTable();
		roadTransportAdapterSQLite.setList(listRoadTransport);
		roadTransportAdapterSQLite.close();
		progressBar.setProgress(72);
		System.out.println("Local Road Transport end");
/* --- Transport end ------------------------------------------------------------------------------------------- 18 --*/
/* --- City start ---------------------------------------------------------------------------------------------- 18 --*/
		GetListQuestionMySQL getListCityQuestion = new GetListCityQuestionMySQLImpl();
		List<QuestionCity> listCity = new ArrayList<>();
		List<Question> cities = getListCityQuestion.getListQuestion(user, context);
		for (Question q : cities) {
			listCity.add((QuestionCity) q);
		}
		System.out.println("External City end");
		progressBar.setProgress(74);
		ListCityLoad.setQuestionList(listCity);
		CityAdapterSQLite cityAdapterSQLite = new CityAdapterSQLite(context);
		cityAdapterSQLite.open();
		cityAdapterSQLite.clearTable();
		cityAdapterSQLite.setList(listCity);
		cityAdapterSQLite.close();
		progressBar.setProgress(76);
		System.out.println("Local City end");
/* --- City end ------------------------------------------------------------------------------------------------ 19 --*/
/* --- Author and Company partners start ----------------------------------------------------------------------- 19 --*/
		GetListAuthorExternalDB getListAuthorExternalDB = new GetListAuthorMySQLImpl();
		List<Author> authors = getListAuthorExternalDB.getListAuthor(user, context);
		ListAuthor.setAuthorsList(authors);
		progressBar.setProgress(78);
		System.out.println("External Author end");
		AuthorAdapterSQLite authorAdapterSQLite = new AuthorAdapterSQLite(context);
		authorAdapterSQLite.open();
		authorAdapterSQLite.clearTable();
		authorAdapterSQLite.setList(authors);
		authorAdapterSQLite.close();
		progressBar.setProgress(80);
		System.out.println("Local Author end");
		/*------------------------------------------------------------------------------------- 20 -*/
		GetListCompanyPartnersExternalDB getListCompanyPartnersExternalDB = new GetListCompanyPartnersImpl();
		List<CompanyPartners> companyPartners = getListCompanyPartnersExternalDB.getListCompanyPartners(user, context);
		ListCompanyPartners.setCompanyPartners(companyPartners);
		progressBar.setProgress(85);
		System.out.println("External companyPartners end");
		CompanyPartnersAdapterSQLite companyPartnersAdapterSQLite = new CompanyPartnersAdapterSQLite(context);
		companyPartnersAdapterSQLite.open();
		companyPartnersAdapterSQLite.clearTable();
		companyPartnersAdapterSQLite.setList(companyPartners);
		companyPartnersAdapterSQLite.close();
		progressBar.setProgress(95);
		System.out.println("Local companyPartners end");
/* --- Author and Company partners end ------------------------------------------------------------------------- 21 --*/
		return true;
	}
}
