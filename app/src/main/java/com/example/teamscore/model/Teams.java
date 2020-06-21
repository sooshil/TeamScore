package com.example.teamscore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Teams {

    @SerializedName("teams")
    @Expose
    private List<Team> teams = null;

    public List<Team> getTeams() {
        return teams;
    }

    public class Team {

        @SerializedName("idTeam")
        @Expose
        private String idTeam;
        @SerializedName("idSoccerXML")
        @Expose
        private String idSoccerXML;
        @SerializedName("idAPIfootball")
        @Expose
        private String idAPIfootball;
        @SerializedName("intLoved")
        @Expose
        private Object intLoved;
        @SerializedName("strTeam")
        @Expose
        private String strTeam;
        @SerializedName("strTeamShort")
        @Expose
        private Object strTeamShort;
        @SerializedName("strAlternate")
        @Expose
        private String strAlternate;
        @SerializedName("intFormedYear")
        @Expose
        private String intFormedYear;
        @SerializedName("strSport")
        @Expose
        private String strSport;
        @SerializedName("strLeague")
        @Expose
        private String strLeague;
        @SerializedName("idLeague")
        @Expose
        private String idLeague;
        @SerializedName("strDivision")
        @Expose
        private Object strDivision;
        @SerializedName("strManager")
        @Expose
        private String strManager;
        @SerializedName("strStadium")
        @Expose
        private String strStadium;
        @SerializedName("strKeywords")
        @Expose
        private String strKeywords;
        @SerializedName("strRSS")
        @Expose
        private String strRSS;
        @SerializedName("strStadiumThumb")
        @Expose
        private Object strStadiumThumb;
        @SerializedName("strStadiumDescription")
        @Expose
        private String strStadiumDescription;
        @SerializedName("strStadiumLocation")
        @Expose
        private String strStadiumLocation;
        @SerializedName("intStadiumCapacity")
        @Expose
        private String intStadiumCapacity;
        @SerializedName("strWebsite")
        @Expose
        private String strWebsite;
        @SerializedName("strFacebook")
        @Expose
        private String strFacebook;
        @SerializedName("strTwitter")
        @Expose
        private String strTwitter;
        @SerializedName("strInstagram")
        @Expose
        private String strInstagram;
        @SerializedName("strDescriptionEN")
        @Expose
        private String strDescriptionEN;
        @SerializedName("strDescriptionDE")
        @Expose
        private Object strDescriptionDE;
        @SerializedName("strDescriptionFR")
        @Expose
        private Object strDescriptionFR;
        @SerializedName("strDescriptionCN")
        @Expose
        private Object strDescriptionCN;
        @SerializedName("strDescriptionIT")
        @Expose
        private Object strDescriptionIT;
        @SerializedName("strDescriptionJP")
        @Expose
        private Object strDescriptionJP;
        @SerializedName("strDescriptionRU")
        @Expose
        private Object strDescriptionRU;
        @SerializedName("strDescriptionES")
        @Expose
        private Object strDescriptionES;
        @SerializedName("strDescriptionPT")
        @Expose
        private Object strDescriptionPT;
        @SerializedName("strDescriptionSE")
        @Expose
        private Object strDescriptionSE;
        @SerializedName("strDescriptionNL")
        @Expose
        private Object strDescriptionNL;
        @SerializedName("strDescriptionHU")
        @Expose
        private Object strDescriptionHU;
        @SerializedName("strDescriptionNO")
        @Expose
        private Object strDescriptionNO;
        @SerializedName("strDescriptionIL")
        @Expose
        private Object strDescriptionIL;
        @SerializedName("strDescriptionPL")
        @Expose
        private Object strDescriptionPL;
        @SerializedName("strGender")
        @Expose
        private String strGender;
        @SerializedName("strCountry")
        @Expose
        private String strCountry;
        @SerializedName("strTeamBadge")
        @Expose
        private String strTeamBadge;
        @SerializedName("strTeamJersey")
        @Expose
        private String strTeamJersey;
        @SerializedName("strTeamLogo")
        @Expose
        private String strTeamLogo;
        @SerializedName("strTeamFanart1")
        @Expose
        private Object strTeamFanart1;
        @SerializedName("strTeamFanart2")
        @Expose
        private Object strTeamFanart2;
        @SerializedName("strTeamFanart3")
        @Expose
        private Object strTeamFanart3;
        @SerializedName("strTeamFanart4")
        @Expose
        private Object strTeamFanart4;
        @SerializedName("strTeamBanner")
        @Expose
        private Object strTeamBanner;
        @SerializedName("strYoutube")
        @Expose
        private String strYoutube;
        @SerializedName("strLocked")
        @Expose
        private String strLocked;

        public String getIdTeam() {
            return idTeam;
        }

        public String getIdSoccerXML() {
            return idSoccerXML;
        }

        public String getIdAPIfootball() {
            return idAPIfootball;
        }

        public Object getIntLoved() {
            return intLoved;
        }

        public String getStrTeam() {
            return strTeam;
        }

        public Object getStrTeamShort() {
            return strTeamShort;
        }

        public String getStrAlternate() {
            return strAlternate;
        }

        public String getIntFormedYear() {
            return intFormedYear;
        }

        public String getStrSport() {
            return strSport;
        }

        public String getStrLeague() {
            return strLeague;
        }

        public String getIdLeague() {
            return idLeague;
        }

        public Object getStrDivision() {
            return strDivision;
        }

        public String getStrManager() {
            return strManager;
        }

        public String getStrStadium() {
            return strStadium;
        }

        public String getStrKeywords() {
            return strKeywords;
        }

        public void setStrKeywords(String strKeywords) {
            this.strKeywords = strKeywords;
        }

        public String getStrRSS() {
            return strRSS;
        }

        public Object getStrStadiumThumb() {
            return strStadiumThumb;
        }

        public String getStrStadiumDescription() {
            return strStadiumDescription;
        }

        public String getStrStadiumLocation() {
            return strStadiumLocation;
        }

        public String getIntStadiumCapacity() {
            return intStadiumCapacity;
        }

        public String getStrWebsite() {
            return strWebsite;
        }

        public String getStrFacebook() {
            return strFacebook;
        }

        public String getStrTwitter() {
            return strTwitter;
        }

        public String getStrInstagram() {
            return strInstagram;
        }

        public String getStrDescriptionEN() {
            return strDescriptionEN;
        }

        public Object getStrDescriptionDE() {
            return strDescriptionDE;
        }

        public Object getStrDescriptionFR() {
            return strDescriptionFR;
        }

        public Object getStrDescriptionCN() {
            return strDescriptionCN;
        }

        public void setStrDescriptionCN(Object strDescriptionCN) {
            this.strDescriptionCN = strDescriptionCN;
        }

        public Object getStrDescriptionIT() {
            return strDescriptionIT;
        }

        public Object getStrDescriptionJP() {
            return strDescriptionJP;
        }

        public Object getStrDescriptionRU() {
            return strDescriptionRU;
        }

        public Object getStrDescriptionES() {
            return strDescriptionES;
        }

        public Object getStrDescriptionPT() {
            return strDescriptionPT;
        }

        public Object getStrDescriptionSE() {
            return strDescriptionSE;
        }

        public Object getStrDescriptionNL() {
            return strDescriptionNL;
        }

        public Object getStrDescriptionHU() {
            return strDescriptionHU;
        }

        public Object getStrDescriptionNO() {
            return strDescriptionNO;
        }

        public Object getStrDescriptionIL() {
            return strDescriptionIL;
        }

        public Object getStrDescriptionPL() {
            return strDescriptionPL;
        }

        public String getStrGender() {
            return strGender;
        }

        public String getStrCountry() {
            return strCountry;
        }

        public String getStrTeamBadge() {
            return strTeamBadge;
        }

        public String getStrTeamJersey() {
            return strTeamJersey;
        }

        public String getStrTeamLogo() {
            return strTeamLogo;
        }

        public Object getStrTeamFanart1() {
            return strTeamFanart1;
        }

        public Object getStrTeamFanart2() {
            return strTeamFanart2;
        }

        public Object getStrTeamFanart3() {
            return strTeamFanart3;
        }

        public Object getStrTeamFanart4() {
            return strTeamFanart4;
        }

        public Object getStrTeamBanner() {
            return strTeamBanner;
        }

        public String getStrYoutube() {
            return strYoutube;
        }


        public String getStrLocked() {
            return strLocked;
        }


    }

}
