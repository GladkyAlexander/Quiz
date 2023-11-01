package ru.great_larder.sportquiz.services.load;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
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
		Single.fromCallable(this::load).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
				.subscribe(this::update);
		
	}
	private void update(boolean a){
		progressBar.setProgress(100);
		progressBar.setVisibility(View.GONE);
		System.out.println("Load questions and author, and company data ok!");
		Toast.makeText(context, "Вопросы успешно обновлены!", Toast.LENGTH_SHORT).show();
	}
	private boolean load(){
		progressBar.setIndeterminate(false);
		GetListQuestionMySQL getListBiologyQuestion = new GetListBiologyQuestionMySQLImpl();
		List<QuestionBiology> list = new ArrayList<>();
		for (Question q : getListBiologyQuestion.getListQuestion(user, context)) {
			list.add((QuestionBiology) q);
		}
		ListBiologyLoad.setQuestionList(list);
		BiologyAdapterSQLite biologyAdapterSQLite = new BiologyAdapterSQLite(context);
		biologyAdapterSQLite.open();
		biologyAdapterSQLite.clearTable();
		biologyAdapterSQLite.setList(list);
		biologyAdapterSQLite.close();
		progressBar.setProgress(7);
		/*--------------------------------------------------------------------------------------*/
		GetListQuestionMySQL getListCityQuestion = new GetListCityQuestionMySQLImpl();
		List<QuestionCity> listCity = new ArrayList<>();
		for (Question q : getListCityQuestion.getListQuestion(user, context)) {
			listCity.add((QuestionCity) q);
		}
		ListCityLoad.setQuestionList(listCity);
		CityAdapterSQLite cityAdapterSQLite = new CityAdapterSQLite(context);
		cityAdapterSQLite.open();
		cityAdapterSQLite.clearTable();
		cityAdapterSQLite.setList(listCity);
		cityAdapterSQLite.close();
		progressBar.setProgress(14);
		/*--------------------------------------------------------------------------------------*/
		GetListQuestionMySQL getListEtiquetteBusinessQuestionMySQL = new GetListEtiquetteBusinessQuestionMySQLImpl();
		List<QuestionEtiquetteBusiness> listEtiquetteBusiness = new ArrayList<>();
		for (Question q : getListEtiquetteBusinessQuestionMySQL.getListQuestion(user, context)) {
			listEtiquetteBusiness.add((QuestionEtiquetteBusiness) q);
		}
		ListEtiquetteBusinessLoad.setQuestionList(listEtiquetteBusiness);
		EtiquetteBusinessAdapterSQLite etiquetteBusinessAdapterSQLite = new EtiquetteBusinessAdapterSQLite(context);
		etiquetteBusinessAdapterSQLite.open();
		etiquetteBusinessAdapterSQLite.clearTable();
		etiquetteBusinessAdapterSQLite.setList(listEtiquetteBusiness);
		etiquetteBusinessAdapterSQLite.close();
		progressBar.setProgress(21);
		/*--------------------------------------------------------------------------------------*/
		GetListQuestionMySQL getListEtiquetteSecular = new GetListEtiquetteSecularQuestionMySQLImpl();
		List<QuestionEtiquetteSecular> listEtiquetteSecular = new ArrayList<>();
		for (Question q : getListEtiquetteSecular.getListQuestion(user, context)) {
			listEtiquetteSecular.add((QuestionEtiquetteSecular) q);
		}
		ListEtiquetteSecularLoad.setQuestionList(listEtiquetteSecular);
		EtiquetteSecularAdapterSQLite etiquetteSecularAdapterSQLite = new EtiquetteSecularAdapterSQLite(context);
		etiquetteSecularAdapterSQLite.open();
		etiquetteSecularAdapterSQLite.clearTable();
		etiquetteSecularAdapterSQLite.setList(listEtiquetteSecular);
		etiquetteSecularAdapterSQLite.close();
		progressBar.setProgress(28);
		/*--------------------------------------------------------------------------------------*/
		GetListQuestionMySQL getListGeographyQuestion = new GetListGeographyQuestionMySQLImpl();
		List<QuestionGeography> listGeographyQuestion = new ArrayList<>();
		for (Question q : getListGeographyQuestion.getListQuestion(user, context)) {
			listGeographyQuestion.add((QuestionGeography) q);
		}
		ListGeographyLoad.setQuestionList(listGeographyQuestion);
		GeographyAdapterSQLite geographyAdapterSQLite = new GeographyAdapterSQLite(context);
		geographyAdapterSQLite.open();
		geographyAdapterSQLite.clearTable();
		geographyAdapterSQLite.setList(listGeographyQuestion);
		geographyAdapterSQLite.close();
		progressBar.setProgress(35);
		/*--------------------------------------------------------------------------------------*/
		GetListQuestionMySQL getListHistoryQuestionMySQL = new GetListHistoryQuestionMySQLImpl();
		List<QuestionHistory> listHistory = new ArrayList<>();
		for (Question q : getListHistoryQuestionMySQL.getListQuestion(user, context)) {
			listHistory.add((QuestionHistory) q);
		}
		ListHistoryLoad.setQuestionList(listHistory);
		HistoryAdapterSQLite historyAdapterSQLite = new HistoryAdapterSQLite(context);
		historyAdapterSQLite.open();
		historyAdapterSQLite.clearTable();
		historyAdapterSQLite.setList(listHistory);
		historyAdapterSQLite.close();
		progressBar.setProgress(42);
		/*--------------------------------------------------------------------------------------*/
		GetListQuestionMySQL getListEnLanguageQuestion = new GetListLanguageEnQuestionMySQLImpl();
		List<QuestionEnLanguage> listEnLanguage = new ArrayList<>();
		for (Question q : getListEnLanguageQuestion.getListQuestion(user, context)) {
			listEnLanguage.add((QuestionEnLanguage) q);
		}
		ListEnLanguageLoad.setQuestionList(listEnLanguage);
		LanguageEnAdapterSQLite languageEnAdapterSQLite = new LanguageEnAdapterSQLite(context);
		languageEnAdapterSQLite.open();
		languageEnAdapterSQLite.clearTable();
		languageEnAdapterSQLite.setList(listEnLanguage);
		languageEnAdapterSQLite.close();
		progressBar.setProgress(49);
		/*--------------------------------------------------------------------------------------*/
		GetListQuestionMySQL getListRuLanguage = new GetListLanguageRuQuestionMySQLImpl();
		List<QuestionRuLanguage> listRuLanguage = new ArrayList<>();
		for (Question q : getListRuLanguage.getListQuestion(user, context)) {
			listRuLanguage.add((QuestionRuLanguage) q);
		}
		ListRuLanguageLoad.setQuestionList(listRuLanguage);
		LanguageRuAdapterSQLite languageRuAdapterSQLite = new LanguageRuAdapterSQLite(context);
		languageRuAdapterSQLite.open();
		languageRuAdapterSQLite.clearTable();
		languageRuAdapterSQLite.setList(listRuLanguage);
		languageRuAdapterSQLite.close();
		progressBar.setProgress(56);
		/*--------------------------------------------------------------------------------------*/
		GetListQuestionMySQL getListMathematicsQuestion = new GetListMathematicsQuestionMySQLImpl();
		List<QuestionMathematics> listMathematics = new ArrayList<>();
		for (Question q : getListMathematicsQuestion.getListQuestion(user, context)) {
			listMathematics.add((QuestionMathematics) q);
		}
		ListMathematicsLoad.setQuestionList(listMathematics);
		MathematicsAdapterSQLite mathematicsAdapterSQLite = new MathematicsAdapterSQLite(context);
		mathematicsAdapterSQLite.open();
		mathematicsAdapterSQLite.clearTable();
		mathematicsAdapterSQLite.setList(listMathematics);
		mathematicsAdapterSQLite.close();
		progressBar.setProgress(63);
		/*--------------------------------------------------------------------------------------*/
		GetListQuestionMySQL getListPhysicsQuestion = new GetListPhysicsQuestionMySQLImpl();
		List<QuestionPhysics> listPhysics = new ArrayList<>();
		for (Question q : getListPhysicsQuestion.getListQuestion(user, context)) {
			listPhysics.add((QuestionPhysics) q);
		}
		ListPhysicsLoad.setQuestionList(listPhysics);
		PhysicsAdapterSQLite physicsAdapterSQLite = new PhysicsAdapterSQLite(context);
		physicsAdapterSQLite.open();
		physicsAdapterSQLite.clearTable();
		physicsAdapterSQLite.setList(listPhysics);
		physicsAdapterSQLite.close();
		progressBar.setProgress(70);
		/*--------------------------------------------------------------------------------------*/
		GetListQuestionMySQL getListSportsQuestion = new GetListSportsQuestionMySQLImpl();
		List<QuestionSports> listSports = new ArrayList<>();
		for (Question q : getListSportsQuestion.getListQuestion(user, context)) {
			listSports.add((QuestionSports) q);
		}
		ListSportsLoad.setQuestionList(listSports);
		SportsAdapterSQLite sportsAdapterSQLite = new SportsAdapterSQLite(context);
		sportsAdapterSQLite.open();
		sportsAdapterSQLite.clearTable();
		sportsAdapterSQLite.setList(listSports);
		sportsAdapterSQLite.close();
		progressBar.setProgress(77);
		/*--------------------------------------------------------------------------------------*/
		GetListQuestionMySQL getListTrafficLaws = new GetListTrafficLawsQuestionMySQLImpl();
		List<QuestionTrafficLaws> listTrafficLaws = new ArrayList<>();
		for (Question q : getListTrafficLaws.getListQuestion(user, context)) {
			listTrafficLaws.add((QuestionTrafficLaws) q);
		}
		ListTrafficLawsLoad.setQuestionList(listTrafficLaws);
		TrafficLawsAdapterSQLite trafficLawsAdapterSQLite = new TrafficLawsAdapterSQLite(context);
		trafficLawsAdapterSQLite.open();
		trafficLawsAdapterSQLite.clearTable();
		trafficLawsAdapterSQLite.setList(listTrafficLaws);
		trafficLawsAdapterSQLite.close();
		progressBar.setProgress(85);
		/*--------------------------------------------------------------------------------------*/
		GetListAuthorExternalDB getListAuthorExternalDB = new GetListAuthorImpl();
		List<Author> authors = getListAuthorExternalDB.getListAuthor(user, context);
		ListAuthor.setAuthorsList(authors);
		AuthorAdapterSQLite authorAdapterSQLite = new AuthorAdapterSQLite(context);
		authorAdapterSQLite.open();
		authorAdapterSQLite.clearTable();
		authorAdapterSQLite.setList(authors);
		authorAdapterSQLite.close();
		progressBar.setProgress(94);
		/*--------------------------------------------------------------------------------------*/
		GetListCompanyPartnersExternalDB getListCompanyPartnersExternalDB = new GetListCompanyPartnersImpl();
		List<CompanyPartners> companyPartners = getListCompanyPartnersExternalDB.getListCompanyPartners(user, context);
		ListCompanyPartners.setCompanyPartners(companyPartners);
		CompanyPartnersAdapterSQLite companyPartnersAdapterSQLite = new CompanyPartnersAdapterSQLite(context);
		companyPartnersAdapterSQLite.open();
		companyPartnersAdapterSQLite.clearTable();
		companyPartnersAdapterSQLite.setList(companyPartners);
		companyPartnersAdapterSQLite.close();
		progressBar.setProgress(99);
		return true;
	}
}
