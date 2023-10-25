package ru.great_larder.sportquiz.database;


import android.content.Context;
import ru.great_larder.sportquiz.database.repository.get_live.*;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.*;
import ru.great_larder.sportquiz.domain.*;
import ru.great_larder.sportquiz.question.*;

import java.util.ArrayList;
import java.util.List;

public class CompareQuestions {
    private final Context context;
    
    public CompareQuestions(Context context) {
        this.context = context;
    }
    
    public void compare(List<?> listMySQL) {
        if (listMySQL != null && !listMySQL.isEmpty()) {
            setSQLiteForEternal(listMySQL);
        } else {
            setSQLiteForLocal();
        }
    }
    
    private void setSQLiteForLocal() {
        authorLoadSQLite();
        companyPartnersSQLite();
        biologyLoadSQLite();
        cityLoadSQLite();
        enLanguageLoadSQLite();
        ruLanguageLoadSQLite();
        etiquetteBusinesslikeSQLite();
        etiquetteSecularLoadSQLite();
        geographyLoadSQLite();
        historyLoadSQLite();
        mathematicsLoadSQLite();
        physicsLoadSQLite();
        sportsLoadSQLite();
        trafficLawsLoadSQLite();
    }
    
    private void companyPartnersSQLite() {
        CompanyPartnersAdapterSQLite companyPartnersAdapterSQLite = new CompanyPartnersAdapterSQLite(context);
        List<CompanyPartners> companyPartnersList;
        companyPartnersAdapterSQLite.open();
        companyPartnersList = companyPartnersAdapterSQLite.getCompanyPartners();
        companyPartnersAdapterSQLite.close();
        setCompanyPartnersSQLite(companyPartnersList);
    }
    
    private void authorLoadSQLite() {
        AuthorAdapterSQLite authorAdapterSQLite = new AuthorAdapterSQLite(context);
        List<Author> authorList;
        authorAdapterSQLite.open();
        authorList = authorAdapterSQLite.getAuthors();
        authorAdapterSQLite.close();
        setAuthorSQLite(authorList);
    }
    
    private void trafficLawsLoadSQLite() {
        TrafficLawsAdapterSQLite trafficLawsAdapterSQLite = new TrafficLawsAdapterSQLite(context);
        List<QuestionTrafficLaws> trafficLawsList;
        trafficLawsAdapterSQLite.open();
        trafficLawsList = trafficLawsAdapterSQLite.getQuestionTrafficLaws();
        trafficLawsAdapterSQLite.close();
        
        if(trafficLawsList.isEmpty()){
            GetQuestionTrafficLawsInside getQuestion = new GetQuestionTrafficLawsInside();
            setTrafficLawsSQLite(getQuestion.getListQuestion(null));
        } else setTrafficLawsSQLite(trafficLawsList);
    }
    
    private void sportsLoadSQLite() {
        SportsAdapterSQLite sportsAdapterSQLite = new SportsAdapterSQLite(context);
        List<QuestionSports> sportsList;
        sportsAdapterSQLite.open();
        sportsList = sportsAdapterSQLite.getQuestionSports();
        sportsAdapterSQLite.close();
        if(sportsList.isEmpty()){
            GetQuestionSportsInside getQuestion = new GetQuestionSportsInside();
            setSportsSQLite(getQuestion.getListQuestion(null));
        } else setSportsSQLite(sportsList);
    }
    
    private void physicsLoadSQLite() {
        PhysicsAdapterSQLite physicsAdapterSQLite = new PhysicsAdapterSQLite(context);
        List<QuestionPhysics> physicsList;
        physicsAdapterSQLite.open();
        physicsList = physicsAdapterSQLite.getQuestionPhysics();
        physicsAdapterSQLite.close();
        if(physicsList != null && physicsList.isEmpty()){
            GetQuestionPhysicsInside getQuestion = new GetQuestionPhysicsInside();
            setPhysicsSQLite(getQuestion.getListQuestion(null));
        } else setPhysicsSQLite(physicsList);
    }
    
    private void mathematicsLoadSQLite() {
        MathematicsAdapterSQLite mathematicsAdapterSQLite = new MathematicsAdapterSQLite(context);
        List<QuestionMathematics> mathematicsList;
        mathematicsAdapterSQLite.open();
        mathematicsList = mathematicsAdapterSQLite.getQuestionMathematics();
        mathematicsAdapterSQLite.close();
        if(mathematicsList.isEmpty()){
            GetQuestionMathematicsInside getQuestion = new GetQuestionMathematicsInside();
            setMathematicsSQLite(getQuestion.getListQuestion(null));
        } else setMathematicsSQLite(mathematicsList);
    }
    
    private void historyLoadSQLite() {
        HistoryAdapterSQLite historyAdapterSQLite = new HistoryAdapterSQLite(context);
        List<QuestionHistory> historyList;
        historyAdapterSQLite.open();
        historyList = historyAdapterSQLite.getQuestionHistory();
        historyAdapterSQLite.close();
        if(historyList.isEmpty()){
            GetQuestionHistoryInside getQuestion = new GetQuestionHistoryInside();
            setHistorySQLite(getQuestion.getListQuestion(null));
        } else setHistorySQLite(historyList);
    }
    
    private void geographyLoadSQLite() {
        GeographyAdapterSQLite geographyAdapterSQLite = new GeographyAdapterSQLite(context);
        List<QuestionGeography> geographyList;
        geographyAdapterSQLite.open();
        geographyList = geographyAdapterSQLite.getQuestionGeography();
        geographyAdapterSQLite.close();
        if(geographyList.isEmpty()){
            GetQuestionGeographyInside getQuestion = new GetQuestionGeographyInside();
            setGeographySQLite(getQuestion.getListQuestion(null));
        } else setGeographySQLite(geographyList);
    }
    
    private void etiquetteSecularLoadSQLite() {
        EtiquetteSecularAdapterSQLite etiquetteSecularAdapterSQLite = new EtiquetteSecularAdapterSQLite(context);
        List<QuestionEtiquetteSecular> etiquetteSecularList;
        etiquetteSecularAdapterSQLite.open();
        etiquetteSecularList = etiquetteSecularAdapterSQLite.getQuestionEtiquetteSecular();
        etiquetteSecularAdapterSQLite.close();
        if(etiquetteSecularList != null && etiquetteSecularList.isEmpty()){
            GetEtiquetteSecularInside getQuestion = new GetEtiquetteSecularInside();
            setEtiquetteSecularSQLite(getQuestion.getListQuestion(null));
        } else setEtiquetteSecularSQLite(etiquetteSecularList);
    }
    
    private void etiquetteBusinesslikeSQLite() {
        EtiquetteBusinessAdapterSQLite etiquetteBusinessAdapterSQLite = new EtiquetteBusinessAdapterSQLite(context);
        List<QuestionEtiquetteBusiness> etiquetteBusinessList;
        etiquetteBusinessAdapterSQLite.open();
        etiquetteBusinessList = etiquetteBusinessAdapterSQLite.getQuestionEtiquetteBusiness();
        etiquetteBusinessAdapterSQLite.close();
        if(etiquetteBusinessList.isEmpty()){
            GetEtiquetteBusinessInside getQuestion = new GetEtiquetteBusinessInside();
            setEtiquetteBusinessSQLite(getQuestion.getListQuestion(null));
        } else setEtiquetteBusinessSQLite(etiquetteBusinessList);
    }
    
    private void ruLanguageLoadSQLite() {
        LanguageRuAdapterSQLite languageRuAdapterSQLite = new LanguageRuAdapterSQLite(context);
        List<QuestionRuLanguage> questionRuLanguageList;
        languageRuAdapterSQLite.open();
        questionRuLanguageList = languageRuAdapterSQLite.getQuestionRuLanguage();
        languageRuAdapterSQLite.close();
        if(questionRuLanguageList.isEmpty()){
            GetQuestionRuLanguageInside getQuestion = new GetQuestionRuLanguageInside();
           setRuLanguagesSQLite(getQuestion.getListQuestion(null));
        } else setRuLanguagesSQLite(questionRuLanguageList);
    }
    
    private void enLanguageLoadSQLite() {
        LanguageEnAdapterSQLite languageEnAdapterSQLite = new LanguageEnAdapterSQLite(context);
        List<QuestionEnLanguage> questionEnLanguageList;
        languageEnAdapterSQLite.open();
        questionEnLanguageList = languageEnAdapterSQLite.getQuestionEnLanguage();
        languageEnAdapterSQLite.close();
        if(questionEnLanguageList != null && questionEnLanguageList.isEmpty()){
            GetQuestionEnLanguageInside getQuestion = new GetQuestionEnLanguageInside();
            setEnLanguageSQLite(getQuestion.getListQuestion(null));
        } else setEnLanguageSQLite(questionEnLanguageList);
    }
    
    private void cityLoadSQLite() {
        CityAdapterSQLite cityAdapterSQLite = new CityAdapterSQLite(context);
        List<QuestionCity> questionCityList;
        cityAdapterSQLite.open();
        questionCityList = cityAdapterSQLite.getQuestionCityes();
        cityAdapterSQLite.close();
        setCitySQLite(questionCityList);
    }
    
    private void biologyLoadSQLite() {
        BiologyAdapterSQLite biologyAdapterSQLite = new BiologyAdapterSQLite(context);
        List<QuestionBiology> questionBiologist;
        biologyAdapterSQLite.open();
        questionBiologist = biologyAdapterSQLite.getQuestionBiology();
        biologyAdapterSQLite.close();
        if(questionBiologist.isEmpty()){
            GetQuestionBiologyInside getQuestion = new GetQuestionBiologyInside();
            setBiologySQLite(getQuestion.getListQuestion(null));
        } else setBiologySQLite(questionBiologist);
    }
    
    private void setSQLiteForEternal(List<?> listMySQL) {
        if (listMySQL.get(0) instanceof QuestionBiology) {
            List<QuestionBiology> questionBiologies = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof QuestionBiology) questionBiologies.add((QuestionBiology) o);
            }
                setBiologySQLite(questionBiologies);
        }
        if (listMySQL.get(0) instanceof QuestionCity) {
            List<QuestionCity> questionCities = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof QuestionCity) questionCities.add((QuestionCity) o);
            }
            setCitySQLite(questionCities);
        }
        if (listMySQL.get(0) instanceof QuestionEtiquetteBusiness) {
            List<QuestionEtiquetteBusiness> questionEtiquetteBusinesses = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof QuestionEtiquetteBusiness) questionEtiquetteBusinesses.add((QuestionEtiquetteBusiness) o);
            }
            setEtiquetteBusinessSQLite(questionEtiquetteBusinesses);
        }
        if (listMySQL.get(0) instanceof QuestionEtiquetteSecular) {
            List<QuestionEtiquetteSecular> questionEtiquetteSeculars = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof QuestionEtiquetteSecular) questionEtiquetteSeculars.add((QuestionEtiquetteSecular) o);
            }
            setEtiquetteSecularSQLite(questionEtiquetteSeculars);
        }
        if (listMySQL.get(0) instanceof QuestionGeography) {
            List<QuestionGeography> questionGeographies = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof QuestionGeography) questionGeographies.add((QuestionGeography) o);
            }
            setGeographySQLite(questionGeographies);
        }
        if (listMySQL.get(0) instanceof QuestionHistory) {
            List<QuestionHistory> questionHistories = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof QuestionHistory) questionHistories.add((QuestionHistory) o);
            }
            setHistorySQLite(questionHistories);
        }
        if (listMySQL.get(0) instanceof QuestionEnLanguage) {
            List<QuestionEnLanguage> questionEnLanguages = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof QuestionEnLanguage) questionEnLanguages.add((QuestionEnLanguage) o);
            }
            setEnLanguageSQLite(questionEnLanguages);
        }
        if (listMySQL.get(0) instanceof QuestionRuLanguage) {
            List<QuestionRuLanguage> questionRuLanguages = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof QuestionRuLanguage) questionRuLanguages.add((QuestionRuLanguage) o);
            }
            setRuLanguagesSQLite(questionRuLanguages);
        }
        if (listMySQL.get(0) instanceof QuestionMathematics) {
            List<QuestionMathematics> questionMathematics = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof QuestionMathematics) questionMathematics.add((QuestionMathematics) o);
            }
            setMathematicsSQLite(questionMathematics);
        }
        if (listMySQL.get(0) instanceof QuestionPhysics) {
            List<QuestionPhysics> questionPhysicsList = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof QuestionPhysics) questionPhysicsList.add((QuestionPhysics) o);
            }
            setPhysicsSQLite(questionPhysicsList);
        }
        if (listMySQL.get(0) instanceof QuestionSports) {
            List<QuestionSports> questionSportsList = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof QuestionSports) questionSportsList.add((QuestionSports) o);
            }
            setSportsSQLite(questionSportsList);
        }
        if (listMySQL.get(0) instanceof QuestionTrafficLaws) {
            List<QuestionTrafficLaws> questionTrafficLawsList = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof QuestionTrafficLaws) questionTrafficLawsList.add((QuestionTrafficLaws) o);
            }
            setTrafficLawsSQLite(questionTrafficLawsList);
        }
        if (listMySQL.get(0) instanceof Author) {
            List<Author> authorList = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof Author) authorList.add((Author) o);
            }
            setAuthorSQLite(authorList);
        }
        if (listMySQL.get(0) instanceof CompanyPartners) {
            List<CompanyPartners> companyPartnersList = new ArrayList<>();
            for (Object o : listMySQL){
                if(o instanceof CompanyPartners) companyPartnersList.add((CompanyPartners) o);
            }
            setCompanyPartnersSQLite(companyPartnersList);
        }
    }
    
    private void setCompanyPartnersSQLite(List<CompanyPartners> companyPartnersList) {
        ListCompanyPartners.setCompanyPartners(companyPartnersList);
        CompanyPartnersAdapterSQLite companyPartnersAdapterSQLite = new CompanyPartnersAdapterSQLite(context);
        companyPartnersAdapterSQLite.open();
        companyPartnersAdapterSQLite.clearTable();
        companyPartnersAdapterSQLite.close();
        for (CompanyPartners f : companyPartnersList) {
            companyPartnersAdapterSQLite.open();
            companyPartnersAdapterSQLite.insert(f);
            companyPartnersAdapterSQLite.close();
        }
    }
    
    private void setAuthorSQLite(List<Author> authorList) {
        ListAuthor.setAuthorsList(authorList);
        AuthorAdapterSQLite authorAdapterSQLite = new AuthorAdapterSQLite(context);
        authorAdapterSQLite.open();
        authorAdapterSQLite.clearTable();
        authorAdapterSQLite.close();
        for (Author f : authorList) {
            authorAdapterSQLite.open();
            authorAdapterSQLite.insert(f);
            authorAdapterSQLite.close();
        }
    }
    
    private void setTrafficLawsSQLite(List<QuestionTrafficLaws> questionTrafficLawsList) {
        ListTrafficLawsLoad.setQuestionList(questionTrafficLawsList);
        TrafficLawsAdapterSQLite trafficLawsAdapterSQLite = new TrafficLawsAdapterSQLite(context);
        trafficLawsAdapterSQLite.open();
        trafficLawsAdapterSQLite.clearTable();
        trafficLawsAdapterSQLite.close();
        for (QuestionTrafficLaws f : questionTrafficLawsList) {
            trafficLawsAdapterSQLite.open();
            trafficLawsAdapterSQLite.insert(f);
            trafficLawsAdapterSQLite.close();
        }
    }
    
    private void setSportsSQLite(List<QuestionSports> questionSportsList) {
        ListSportsLoad.setQuestionList(questionSportsList);
        SportsAdapterSQLite sportsAdapterSQLite = new SportsAdapterSQLite(context);
        sportsAdapterSQLite.open();
        sportsAdapterSQLite.clearTable();
        sportsAdapterSQLite.close();
        for (QuestionSports f : questionSportsList) {
            sportsAdapterSQLite.open();
            sportsAdapterSQLite.insert(f);
            sportsAdapterSQLite.close();
        }
    }
    
    private void setPhysicsSQLite(List<QuestionPhysics> questionPhysicsList) {
        ListPhysicsLoad.setQuestionList(questionPhysicsList);
        PhysicsAdapterSQLite physicsAdapterSQLite = new PhysicsAdapterSQLite(context);
        physicsAdapterSQLite.open();
        physicsAdapterSQLite.clearTable();
        physicsAdapterSQLite.close();
        for (QuestionPhysics f : questionPhysicsList) {
            physicsAdapterSQLite.open();
            physicsAdapterSQLite.insert(f);
            physicsAdapterSQLite.close();
        }
    }
    
    private void setMathematicsSQLite(List<QuestionMathematics> questionMathematics) {
        ListMathematicsLoad.setQuestionList(questionMathematics);
        MathematicsAdapterSQLite mathematicsAdapterSQLite = new MathematicsAdapterSQLite(context);
        mathematicsAdapterSQLite.open();
        mathematicsAdapterSQLite.clearTable();
        mathematicsAdapterSQLite.close();
        for (QuestionMathematics f : questionMathematics) {
            mathematicsAdapterSQLite.open();
            mathematicsAdapterSQLite.insert(f);
            mathematicsAdapterSQLite.close();
        }
    }
    
    private void setRuLanguagesSQLite(List<QuestionRuLanguage> questionRuLanguages) {
        ListRuLanguageLoad.setQuestionList(questionRuLanguages);
        LanguageRuAdapterSQLite languageRuAdapterSQLite = new LanguageRuAdapterSQLite(context);
        languageRuAdapterSQLite.open();
        languageRuAdapterSQLite.clearTable();
        languageRuAdapterSQLite.close();
        for (QuestionRuLanguage f : questionRuLanguages) {
            languageRuAdapterSQLite.open();
            languageRuAdapterSQLite.insert(f);
            languageRuAdapterSQLite.close();
        }
    }
    
    private void setEnLanguageSQLite(List<QuestionEnLanguage> questionEnLanguages) {
        ListEnLanguageLoad.setQuestionList(questionEnLanguages);
        LanguageEnAdapterSQLite languageEnAdapterSQLite = new LanguageEnAdapterSQLite(context);
        languageEnAdapterSQLite.open();
        languageEnAdapterSQLite.clearTable();
        languageEnAdapterSQLite.close();
        for (QuestionEnLanguage f : questionEnLanguages) {
            languageEnAdapterSQLite.open();
            languageEnAdapterSQLite.insert(f);
            languageEnAdapterSQLite.close();
        }
    }
    
    private void setHistorySQLite(List<QuestionHistory> questionHistories) {
        ListHistoryLoad.setQuestionList(questionHistories);
        HistoryAdapterSQLite historyAdapterSQLite = new HistoryAdapterSQLite(context);
        historyAdapterSQLite.open();
        historyAdapterSQLite.clearTable();
        historyAdapterSQLite.close();
        for (QuestionHistory f : questionHistories) {
            historyAdapterSQLite.open();
            historyAdapterSQLite.insert(f);
            historyAdapterSQLite.close();
        }
    }
    
    private void setGeographySQLite(List<QuestionGeography> questionGeographies) {
        ListGeographyLoad.setQuestionList(questionGeographies);
        GeographyAdapterSQLite geographyAdapterSQLite = new GeographyAdapterSQLite(context);
        geographyAdapterSQLite.open();
        geographyAdapterSQLite.clearTable();
        geographyAdapterSQLite.close();
        for (QuestionGeography f : questionGeographies) {
            geographyAdapterSQLite.open();
            geographyAdapterSQLite.insert(f);
            geographyAdapterSQLite.close();
        }
    }
    
    private void setEtiquetteSecularSQLite(List<QuestionEtiquetteSecular> questionEtiquetteSeculars) {
        ListEtiquetteSecularLoad.setQuestionList(questionEtiquetteSeculars);
        EtiquetteSecularAdapterSQLite etiquetteSecularAdapterSQLite = new EtiquetteSecularAdapterSQLite(context);
        etiquetteSecularAdapterSQLite.open();
        etiquetteSecularAdapterSQLite.clearTable();
        etiquetteSecularAdapterSQLite.close();
        for (QuestionEtiquetteSecular f : questionEtiquetteSeculars) {
            etiquetteSecularAdapterSQLite.open();
            etiquetteSecularAdapterSQLite.insert(f);
            etiquetteSecularAdapterSQLite.close();
        }
    }
    
    private void setEtiquetteBusinessSQLite(List<QuestionEtiquetteBusiness> questionEtiquetteBusinesses) {
        ListEtiquetteBusinessLoad.setQuestionList(questionEtiquetteBusinesses);
        EtiquetteBusinessAdapterSQLite etiquetteBusinessAdapterSQLite = new EtiquetteBusinessAdapterSQLite(context);
        etiquetteBusinessAdapterSQLite.open();
        etiquetteBusinessAdapterSQLite.clearTable();
        etiquetteBusinessAdapterSQLite.close();
        for (QuestionEtiquetteBusiness f : questionEtiquetteBusinesses) {
            etiquetteBusinessAdapterSQLite.open();
            etiquetteBusinessAdapterSQLite.insert(f);
            etiquetteBusinessAdapterSQLite.close();
        }
    }
    
    private void setCitySQLite(List<QuestionCity> questionCities) {
            ListCityLoad.setQuestionList(questionCities);
            CityAdapterSQLite cityAdapterSQLite = new CityAdapterSQLite(context);
            cityAdapterSQLite.open();
            cityAdapterSQLite.clearTable();
            cityAdapterSQLite.close();
            for (QuestionCity f : questionCities) {
                cityAdapterSQLite.open();
                cityAdapterSQLite.insert(f);
                cityAdapterSQLite.close();
            }
    }
    
    private void setBiologySQLite(List<QuestionBiology> list) {
        ListBiologyLoad.setQuestionList(list);
        BiologyAdapterSQLite biologyAdapterSQLite = new BiologyAdapterSQLite(context);
        biologyAdapterSQLite.open();
        biologyAdapterSQLite.clearTable();
        biologyAdapterSQLite.close();
        for (QuestionBiology f : list) {
            biologyAdapterSQLite.open();
            biologyAdapterSQLite.insert(f);
            biologyAdapterSQLite.close();
        }
    }
    
}
