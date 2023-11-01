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
		System.out.println("Load questions and author, and company data ok!");
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
		CityAdapterSQLite cityAdapterSQLite = new CityAdapterSQLite(context);
		List<QuestionCity> questionCityList;
		cityAdapterSQLite.open();
		questionCityList = cityAdapterSQLite.getQuestionCityes();
		cityAdapterSQLite.close();
		ListCityLoad.setQuestionList(questionCityList);
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
		TrafficLawsAdapterSQLite trafficLawsAdapterSQLite = new TrafficLawsAdapterSQLite(context);
		List<QuestionTrafficLaws> trafficLawsList;
		trafficLawsAdapterSQLite.open();
		trafficLawsList = trafficLawsAdapterSQLite.getQuestionTrafficLaws();
		trafficLawsAdapterSQLite.close();
		if(trafficLawsList != null && trafficLawsList.isEmpty()){
			GetQuestionTrafficLawsInside getQuestionTrafficLawsInside = new GetQuestionTrafficLawsInside();
			ListTrafficLawsLoad.setQuestionList(getQuestionTrafficLawsInside.getListQuestion(null));
		}else ListTrafficLawsLoad.setQuestionList(trafficLawsList);
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
