package ru.great_larder.sportquiz.services.load;

import android.content.Context;
import android.widget.Toast;
import ru.great_larder.sportquiz.database.repository.get_live.*;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.*;
import ru.great_larder.sportquiz.domain.*;
import ru.great_larder.sportquiz.question.*;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.List;

public class LoadDataFromSQLiteFolLocal {
	private Context context;
	public void load(Context context) {
		this.context = context;
		Single.fromCallable(this::load).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
				.subscribe(this::update);
	}
	private void update(boolean a){
		System.out.println("Load local questions and author, and company data ok!");
		Toast.makeText(context, "Вопросы загрузились успешно!", Toast.LENGTH_SHORT).show();
	}
	private boolean load(){
		BiologyAdapterSQLite biologyAdapterSQLite = new BiologyAdapterSQLite(context);
		List<QuestionBiology> questionBiologist;
		biologyAdapterSQLite.open();
		questionBiologist = biologyAdapterSQLite.getQuestionBiology();
		biologyAdapterSQLite.close();
		if(questionBiologist != null && questionBiologist.isEmpty()){
			GetQuestionBiologyInside getQuestionBiologyInside = new GetQuestionBiologyInside();
			ListBiologyLoad.setQuestionList(getQuestionBiologyInside.getListQuestion(null));
		} else ListBiologyLoad.setQuestionList(questionBiologist);
		/*----------------------------------------------------------------*/
		EtiquetteBusinessAdapterSQLite etiquetteBusinessAdapterSQLite = new EtiquetteBusinessAdapterSQLite(context);
		List<QuestionEtiquetteBusiness> etiquetteBusinessList;
		etiquetteBusinessAdapterSQLite.open();
		etiquetteBusinessList = etiquetteBusinessAdapterSQLite.getQuestionEtiquetteBusiness();
		etiquetteBusinessAdapterSQLite.close();
		if(etiquetteBusinessList != null && etiquetteBusinessList.isEmpty()){
			GetEtiquetteBusinessInside getEtiquetteBusinessInside = new GetEtiquetteBusinessInside();
			ListEtiquetteBusinessLoad.setQuestionList(getEtiquetteBusinessInside.getListQuestion(null));
		} else ListEtiquetteBusinessLoad.setQuestionList(etiquetteBusinessList);
		/*----------------------------------------------------------------*/
		EtiquetteSecularAdapterSQLite etiquetteSecularAdapterSQLite = new EtiquetteSecularAdapterSQLite(context);
		List<QuestionEtiquetteSecular> etiquetteSecularList;
		etiquetteSecularAdapterSQLite.open();
		etiquetteSecularList = etiquetteSecularAdapterSQLite.getQuestionEtiquetteSecular();
		etiquetteSecularAdapterSQLite.close();
		if(etiquetteSecularList != null && etiquetteSecularList.isEmpty()){
			GetEtiquetteSecularInside getEtiquetteSecularInside = new GetEtiquetteSecularInside();
			ListEtiquetteSecularLoad.setQuestionList(getEtiquetteSecularInside.getListQuestion(null));
		} else ListEtiquetteSecularLoad.setQuestionList(etiquetteSecularList);
		/*----------------------------------------------------------------*/
		GeographyAdapterSQLite geographyAdapterSQLite = new GeographyAdapterSQLite(context);
		List<QuestionGeography> geographyList;
		geographyAdapterSQLite.open();
		geographyList = geographyAdapterSQLite.getQuestionGeography();
		geographyAdapterSQLite.close();
		if(geographyList != null && geographyList.isEmpty()){
			GetQuestionGeographyInside getQuestionGeographyInside = new GetQuestionGeographyInside();
			ListGeographyLoad.setQuestionList(getQuestionGeographyInside.getListQuestion(null));
		}else ListGeographyLoad.setQuestionList(geographyList);
		/*----------------------------------------------------------------*/
		HistoryAdapterSQLite historyAdapterSQLite = new HistoryAdapterSQLite(context);
		List<QuestionHistory> historyList;
		historyAdapterSQLite.open();
		historyList = historyAdapterSQLite.getQuestionHistory();
		historyAdapterSQLite.close();
		if(historyList != null && historyList.isEmpty()){
			GetQuestionHistoryInside getQuestionHistoryInside = new GetQuestionHistoryInside();
			ListHistoryLoad.setQuestionList(getQuestionHistoryInside.getListQuestion(null));
		} else ListHistoryLoad.setQuestionList(historyList);
		/*----------------------------------------------------------------*/
		MathematicsAdapterSQLite mathematicsAdapterSQLite = new MathematicsAdapterSQLite(context);
		List<QuestionMathematics> mathematicsList;
		mathematicsAdapterSQLite.open();
		mathematicsList = mathematicsAdapterSQLite.getQuestionMathematics();
		mathematicsAdapterSQLite.close();
		if(mathematicsList != null && mathematicsList.isEmpty()){
			GetQuestionMathematicsInside getQuestionMathematicsInside = new GetQuestionMathematicsInside();
			ListMathematicsLoad.setQuestionList(getQuestionMathematicsInside.getListQuestion(null));
		} else ListMathematicsLoad.setQuestionList(mathematicsList);
		/*----------------------------------------------------------------*/
		PhysicsAdapterSQLite physicsAdapterSQLite = new PhysicsAdapterSQLite(context);
		List<QuestionPhysics> physicsList;
		physicsAdapterSQLite.open();
		physicsList = physicsAdapterSQLite.getQuestionPhysics();
		physicsAdapterSQLite.close();
		if(physicsList != null && physicsList.isEmpty()){
			GetQuestionPhysicsInside getQuestionPhysicsInside = new GetQuestionPhysicsInside();
			ListPhysicsLoad.setQuestionList(getQuestionPhysicsInside.getListQuestion(null));
		} else ListPhysicsLoad.setQuestionList(physicsList);
		/*----------------------------------------------------------------*/
		SocialStudiesAdapterSQLite socialStudiesAdapterSQLite = new SocialStudiesAdapterSQLite(context);
		List<QuestionSocialStudies> socialStudiesList;
		socialStudiesAdapterSQLite.open();
		socialStudiesList = socialStudiesAdapterSQLite.getQuestionSocialStudies();
		socialStudiesAdapterSQLite.close();
		if(socialStudiesList != null && socialStudiesList.isEmpty()){
			GetQuestionSocialStudiesInside getQuestionSocialStudiesInside = new GetQuestionSocialStudiesInside();
			ListSocialStudiesLoad.setQuestionList(getQuestionSocialStudiesInside.getListQuestion(null));
		}else ListSocialStudiesLoad.setQuestionList(socialStudiesList);
		/*----------------------------------------------------------------*/
		SportsAdapterSQLite sportsAdapterSQLite = new SportsAdapterSQLite(context);
		List<QuestionSports> sportsList;
		sportsAdapterSQLite.open();
		sportsList = sportsAdapterSQLite.getQuestionSports();
		sportsAdapterSQLite.close();
		if(sportsList != null && sportsList.isEmpty()){
			GetQuestionSportsInside getQuestionSportsInside = new GetQuestionSportsInside();
			ListSportsLoad.setQuestionList(getQuestionSportsInside.getListQuestion(null));
		} else ListSportsLoad.setQuestionList(sportsList);
		/*----------------------------------------------------------------*/
		LanguageBashkirAdapterSQLite bashkirLanguageAdapterSQLite = new LanguageBashkirAdapterSQLite(context);
		List<QuestionBashkirLanguage> bashkirLanguageList;
		bashkirLanguageAdapterSQLite.open();
		bashkirLanguageList = bashkirLanguageAdapterSQLite.getQuestionBashkirLanguage();
		bashkirLanguageAdapterSQLite.close();
		if(bashkirLanguageList != null && bashkirLanguageList.isEmpty()){
			GetQuestionBashkirLanguageInside getQuestioBashkirLanguageInside = new GetQuestionBashkirLanguageInside();
			ListBashkirLanguageLoad.setQuestionList(getQuestioBashkirLanguageInside.getListQuestion(null));
		}else ListBashkirLanguageLoad.setQuestionList(bashkirLanguageList);
		/*----------------------------------------------------------------*/
		LanguageChuvashAdapterSQLite chuvashLanguageAdapterSQLite = new LanguageChuvashAdapterSQLite(context);
		List<QuestionChuvashLanguage> chuvashLanguageList;
		chuvashLanguageAdapterSQLite.open();
		chuvashLanguageList = chuvashLanguageAdapterSQLite.getQuestionChuvashLanguage();
		chuvashLanguageAdapterSQLite.close();
		if(chuvashLanguageList != null && chuvashLanguageList.isEmpty()){
			GetQuestionChuvashLanguageInside getQuestioChuvashLanguageInside = new GetQuestionChuvashLanguageInside();
			ListChuvashLanguageLoad.setQuestionList(getQuestioChuvashLanguageInside.getListQuestion(null));
		}else ListChuvashLanguageLoad.setQuestionList(chuvashLanguageList);
		/*----------------------------------------------------------------*/
		LanguageEnAdapterSQLite languageEnAdapterSQLite = new LanguageEnAdapterSQLite(context);
		List<QuestionEnLanguage> questionEnLanguageList;
		languageEnAdapterSQLite.open();
		questionEnLanguageList = languageEnAdapterSQLite.getQuestionEnLanguage();
		languageEnAdapterSQLite.close();
		if(questionEnLanguageList != null && questionEnLanguageList.isEmpty()){
			GetQuestionEnLanguageInside getQuestionEnLanguageInside = new GetQuestionEnLanguageInside();
			ListEnLanguageLoad.setQuestionList(getQuestionEnLanguageInside.getListQuestion(null));
		} else ListEnLanguageLoad.setQuestionList(questionEnLanguageList);
		/*----------------------------------------------------------------*/
		LanguageRuAdapterSQLite languageRuAdapterSQLite = new LanguageRuAdapterSQLite(context);
		List<QuestionRuLanguage> questionRuLanguageList;
		languageRuAdapterSQLite.open();
		questionRuLanguageList = languageRuAdapterSQLite.getQuestionRuLanguage();
		languageRuAdapterSQLite.close();
		if(questionRuLanguageList != null && questionRuLanguageList.isEmpty()){
			GetQuestionRuLanguageInside getQuestionRuLanguageInside = new GetQuestionRuLanguageInside();
			ListRuLanguageLoad.setQuestionList(getQuestionRuLanguageInside.getListQuestion(null));
		} else ListRuLanguageLoad.setQuestionList(questionRuLanguageList);
		/*----------------------------------------------------------------*/
		LanguageChechenAdapterSQLite languageChechenAdapterSQLite = new LanguageChechenAdapterSQLite(context);
		List<QuestionChechenLanguage> questionChechenLanguages;
		languageChechenAdapterSQLite.open();
		questionChechenLanguages = languageChechenAdapterSQLite.getQuestionChechenLanquage();
		languageChechenAdapterSQLite.close();
		if(questionChechenLanguages != null && questionChechenLanguages.isEmpty()){
			GetQuestionChechenLanguageInside getQuestionChechenLanguageInside = new GetQuestionChechenLanguageInside();
			ListChechenLanguageLoad.setQuestionList(getQuestionChechenLanguageInside.getListQuestion(null));
		} else ListChechenLanguageLoad.setQuestionList(questionChechenLanguages);
		/*----------------------------------------------------------------*/
		LanguageTatarAdapterSQLite languageTatarAdapterSQLite = new LanguageTatarAdapterSQLite(context);
		List<QuestionTatarLanguage> tatarLanguageList;
		languageTatarAdapterSQLite.open();
		tatarLanguageList = languageTatarAdapterSQLite.getQuestionTatarLanquage();
		languageTatarAdapterSQLite.close();
		if(tatarLanguageList != null && tatarLanguageList.isEmpty()){
			GetQuestionTatarLanguageInside getQuestionTatarLanguageInside = new GetQuestionTatarLanguageInside();
			ListTatarLanguageLoad.setQuestionList(getQuestionTatarLanguageInside.getListQuestion(null));
		} else ListTatarLanguageLoad.setQuestionList(tatarLanguageList);
		/*----------------------------------------------------------------*/
		AviationTransportAdapterSQLite aviationTransportAdapterSQLite = new AviationTransportAdapterSQLite(context);
		List<QuestionAviationTransport> aviationTransportList;
		aviationTransportAdapterSQLite.open();
		aviationTransportList = aviationTransportAdapterSQLite.getQuestionAviationTransport();
		aviationTransportAdapterSQLite.close();
		if(aviationTransportList != null && aviationTransportList.isEmpty()){
			GetQuestionAviationTransportInside getQuestionAviationTransportInside = new GetQuestionAviationTransportInside();
			ListAviationTransportLoad.setQuestionList(getQuestionAviationTransportInside.getListQuestion(null));
		}else ListAviationTransportLoad.setQuestionList(aviationTransportList);
		/*----------------------------------------------------------------*/
		RailwayTransportAdapterSQLite railwayTransportAdapterSQLite = new RailwayTransportAdapterSQLite(context);
		List<QuestionRailwayTransport> railwayTransportList;
		railwayTransportAdapterSQLite.open();
		railwayTransportList = railwayTransportAdapterSQLite.getQuestionRailwayTransport();
		railwayTransportAdapterSQLite.close();
		if(railwayTransportList != null && railwayTransportList.isEmpty()){
			GetQuestionRailwayTransportInside getQuestionRailwayTransportInside = new GetQuestionRailwayTransportInside();
			ListRailwayTransportLoad.setQuestionList(getQuestionRailwayTransportInside.getListQuestion(null));
		}else ListRailwayTransportLoad.setQuestionList(railwayTransportList);
		/*----------------------------------------------------------------*/
		RoadTransportAdapterSQLite roadTransportAdapterSQLite = new RoadTransportAdapterSQLite(context);
		List<QuestionRoadTransport> roadTransportList;
		roadTransportAdapterSQLite.open();
		roadTransportList = roadTransportAdapterSQLite.getQuestionRoadTransport();
		roadTransportAdapterSQLite.close();
		if(roadTransportList != null && roadTransportList.isEmpty()){
			GetQuestionRoadTransportInside getQuestionRoadTransportInside = new GetQuestionRoadTransportInside();
			ListRoadTransportLoad.setQuestionList(getQuestionRoadTransportInside.getListQuestion(null));
		}else ListRoadTransportLoad.setQuestionList(roadTransportList);
		/*----------------------------------------------------------------*/
		CityAdapterSQLite cityAdapterSQLite = new CityAdapterSQLite(context);
		List<QuestionCity> questionCityList;
		cityAdapterSQLite.open();
		questionCityList = cityAdapterSQLite.getQuestionCityes();
		cityAdapterSQLite.close();
		ListCityLoad.setQuestionList(questionCityList);
		/*----------------------------------------------------------------*/
		AuthorAdapterSQLite authorAdapterSQLite = new AuthorAdapterSQLite(context);
		List<Author> authorList;
		authorAdapterSQLite.open();
		authorList = authorAdapterSQLite.getAuthors();
		authorAdapterSQLite.close();
		ListAuthor.setAuthorsList(authorList);
		/*----------------------------------------------------------------*/
		CompanyPartnersAdapterSQLite companyPartnersAdapterSQLite = new CompanyPartnersAdapterSQLite(context);
		List<CompanyPartners> companyPartnersList;
		companyPartnersAdapterSQLite.open();
		companyPartnersList = companyPartnersAdapterSQLite.getCompanyPartners();
		companyPartnersAdapterSQLite.close();
		ListCompanyPartners.setCompanyPartners(companyPartnersList);
		
		return true;
	}
	
}
