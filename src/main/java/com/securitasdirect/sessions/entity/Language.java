package com.securitasdirect.sessions.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Language")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l"),
		@NamedQuery(name = "Language.findByIdlang", query = "SELECT l FROM Language l WHERE l.idlang = :idlang"),
		@NamedQuery(name = "Language.findByDescription", query = "SELECT l FROM Language l WHERE l.description = :description"),
		@NamedQuery(name = "Language.findByLanguage", query = "SELECT l FROM Language l WHERE l.language = :language"),
		@NamedQuery(name = "Language.findByLanguageISO", query = "SELECT l FROM Language l WHERE l.languageISO = :languageISO"),
		@NamedQuery(name = "Language.findByCountry", query = "SELECT l FROM Language l WHERE l.country = :country"),
		@NamedQuery(name = "Language.findByCountrysopa", query = "SELECT l FROM Language l WHERE l.countrysopa = :countrysopa"),
		@NamedQuery(name = "Language.findByTimezone", query = "SELECT l FROM Language l WHERE l.timezone = :timezone"),
		@NamedQuery(name = "Language.findByPrefix", query = "SELECT l FROM Language l WHERE l.prefix = :prefix"),
		@NamedQuery(name = "Language.findByDebt", query = "SELECT l FROM Language l WHERE l.debt = :debt"),
		@NamedQuery(name = "Language.findByAlarm", query = "SELECT l FROM Language l WHERE l.alarm = :alarm"),
		@NamedQuery(name = "Language.findByPanelLine", query = "SELECT l FROM Language l WHERE l.panelLine = :panelLine"),
		@NamedQuery(name = "Language.findByLoginTries", query = "SELECT l FROM Language l WHERE l.loginTries = :loginTries"),
		@NamedQuery(name = "Language.findByLoginTriesNoExist", query = "SELECT l FROM Language l WHERE l.loginTriesNoExist = :loginTriesNoExist"),
		@NamedQuery(name = "Language.findByMultiImg", query = "SELECT l FROM Language l WHERE l.multiImg = :multiImg"),
		@NamedQuery(name = "Language.findByDealerCid", query = "SELECT l FROM Language l WHERE l.dealerCid = :dealerCid"),
		@NamedQuery(name = "Language.findByGMTDifference", query = "SELECT l FROM Language l WHERE l.gMTDifference = :gMTDifference"),
		@NamedQuery(name = "Language.findByCustomerCarePhoneNumber", query = "SELECT l FROM Language l WHERE l.customerCarePhoneNumber = :customerCarePhoneNumber"),
		@NamedQuery(name = "Language.findByWebSiteURL", query = "SELECT l FROM Language l WHERE l.webSiteURL = :webSiteURL"),
		@NamedQuery(name = "Language.findByVoicePortalPhoneNumber", query = "SELECT l FROM Language l WHERE l.voicePortalPhoneNumber = :voicePortalPhoneNumber"),
		@NamedQuery(name = "Language.findByMaxLengthNumInst", query = "SELECT l FROM Language l WHERE l.maxLengthNumInst = :maxLengthNumInst"),
		@NamedQuery(name = "Language.findByDealer", query = "SELECT l FROM Language l WHERE l.dealer = :dealer"),
		@NamedQuery(name = "Language.findByCustomerWeb", query = "SELECT l FROM Language l WHERE l.customerWeb = :customerWeb"),
		@NamedQuery(name = "Language.findByHasDealer", query = "SELECT l FROM Language l WHERE l.hasDealer = :hasDealer"),
		@NamedQuery(name = "Language.findByCompanyName", query = "SELECT l FROM Language l WHERE l.companyName = :companyName"),
		@NamedQuery(name = "Language.findByCurrencyCost", query = "SELECT l FROM Language l WHERE l.currencyCost = :currencyCost"),
		@NamedQuery(name = "Language.findByFreeImageRequest", query = "SELECT l FROM Language l WHERE l.freeImageRequest = :freeImageRequest"),
		@NamedQuery(name = "Language.findByCurrency", query = "SELECT l FROM Language l WHERE l.currency = :currency"),
		@NamedQuery(name = "Language.findByTax", query = "SELECT l FROM Language l WHERE l.tax = :tax"),
		@NamedQuery(name = "Language.findByCountryTickets", query = "SELECT l FROM Language l WHERE l.countryTickets = :countryTickets"),
		@NamedQuery(name = "Language.findByDaysToResetPwd", query = "SELECT l FROM Language l WHERE l.daysToResetPwd = :daysToResetPwd"),
		@NamedQuery(name = "Language.findByFreeSMSLimit", query = "SELECT l FROM Language l WHERE l.freeSMSLimit = :freeSMSLimit"),
		@NamedQuery(name = "Language.findByFromEmailATC", query = "SELECT l FROM Language l WHERE l.fromEmailATC = :fromEmailATC"),
		@NamedQuery(name = "Language.findByUrlSopaPro", query = "SELECT l FROM Language l WHERE l.urlSopaPro = :urlSopaPro"),
		@NamedQuery(name = "Language.findByUrlSopaPre", query = "SELECT l FROM Language l WHERE l.urlSopaPre = :urlSopaPre"),
		@NamedQuery(name = "Language.findByOperator", query = "SELECT l FROM Language l WHERE l.operator = :operator"),
		@NamedQuery(name = "Language.findByUrlTicketsPro", query = "SELECT l FROM Language l WHERE l.urlTicketsPro = :urlTicketsPro"),
		@NamedQuery(name = "Language.findByUrlTicketsPre", query = "SELECT l FROM Language l WHERE l.urlTicketsPre = :urlTicketsPre"),
		@NamedQuery(name = "Language.findByUrli2cPro", query = "SELECT l FROM Language l WHERE l.urli2cPro = :urli2cPro"),
		@NamedQuery(name = "Language.findByUrli2cPre", query = "SELECT l FROM Language l WHERE l.urli2cPre = :urli2cPre"),
		@NamedQuery(name = "Language.findByNumPhotosSecImg", query = "SELECT l FROM Language l WHERE l.numPhotosSecImg = :numPhotosSecImg"),
		@NamedQuery(name = "Language.findByPhisicAddress1", query = "SELECT l FROM Language l WHERE l.phisicAddress1 = :phisicAddress1"),
		@NamedQuery(name = "Language.findByPhisicAddress2", query = "SELECT l FROM Language l WHERE l.phisicAddress2 = :phisicAddress2"),
		@NamedQuery(name = "Language.findByMyVerisureUrlIOS", query = "SELECT l FROM Language l WHERE l.myVerisureUrlIOS = :myVerisureUrlIOS"),
		@NamedQuery(name = "Language.findByMyVerisureUrlAndroid", query = "SELECT l FROM Language l WHERE l.myVerisureUrlAndroid = :myVerisureUrlAndroid"),
		@NamedQuery(name = "Language.findByMyVerisureUrlBlackberry", query = "SELECT l FROM Language l WHERE l.myVerisureUrlBlackberry = :myVerisureUrlBlackberry"),
		@NamedQuery(name = "Language.findByMyVerisureUrlWindowsPhone", query = "SELECT l FROM Language l WHERE l.myVerisureUrlWindowsPhone = :myVerisureUrlWindowsPhone"),
		@NamedQuery(name = "Language.findByServiceDataSystem", query = "SELECT l FROM Language l WHERE l.serviceDataSystem = :serviceDataSystem"),
		@NamedQuery(name = "Language.findByUrlBills", query = "SELECT l FROM Language l WHERE l.urlBills = :urlBills"),
		@NamedQuery(name = "Language.findByHasCountryDisclamers", query = "SELECT l FROM Language l WHERE l.hasCountryDisclamers = :hasCountryDisclamers") })
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@NotNull
	@Column(name = "idlang")
	private int idlang;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "description")
	private String description;
	@Size(max = 5)
	@Column(name = "language")
	private String language;
	@Size(max = 10)
	@Column(name = "languageISO")
	private String languageISO;
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 5)
	@Column(name = "country")
	private String country;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 5)
	@Column(name = "countrysopa")
	private String countrysopa;
	@Size(max = 50)
	@Column(name = "timezone")
	private String timezone;
	@Size(max = 5)
	@Column(name = "prefix")
	private String prefix;
	@Column(name = "debt")
	private Integer debt;
	@Column(name = "alarm")
	private Integer alarm;
	@Column(name = "panelLine")
	private Integer panelLine;
	@Column(name = "loginTries")
	private Integer loginTries;
	@Column(name = "loginTriesNoExist")
	private Integer loginTriesNoExist;
	@Column(name = "multiImg")
	private Integer multiImg;
	@Size(max = 4)
	@Column(name = "dealer_cid")
	private String dealerCid;
	@Column(name = "GMTDifference")
	private Integer gMTDifference;
	@Size(max = 60)
	@Column(name = "customerCarePhoneNumber")
	private String customerCarePhoneNumber;
	@Size(max = 40)
	@Column(name = "webSiteURL")
	private String webSiteURL;
	@Size(max = 40)
	@Column(name = "voicePortalPhoneNumber")
	private String voicePortalPhoneNumber;
	@Column(name = "maxLengthNumInst")
	private Integer maxLengthNumInst;
	@Size(max = 10)
	@Column(name = "dealer")
	private String dealer;
	@Size(max = 100)
	@Column(name = "customerWeb")
	private String customerWeb;
	@Basic(optional = false)
	@NotNull
	@Column(name = "hasDealer")
	private int hasDealer;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 30)
	@Column(name = "companyName")
	private String companyName;
	@Size(max = 20)
	@Column(name = "currency_cost")
	private String currencyCost;
	@Column(name = "freeImageRequest")
	private Integer freeImageRequest;
	@Size(max = 10)
	@Column(name = "currency")
	private String currency;
	@Size(max = 10)
	@Column(name = "tax")
	private String tax;
	@Size(max = 5)
	@Column(name = "CountryTickets")
	private String countryTickets;
	@Basic(optional = false)
	@NotNull
	@Column(name = "DaysToResetPwd")
	private int daysToResetPwd;
	@Basic(optional = false)
	@NotNull
	@Column(name = "freeSMSLimit")
	private int freeSMSLimit;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 40)
	@Column(name = "fromEmailATC")
	private String fromEmailATC;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 80)
	@Column(name = "urlSopaPro")
	private String urlSopaPro;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 80)
	@Column(name = "urlSopaPre")
	private String urlSopaPre;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "operator")
	private String operator;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 80)
	@Column(name = "urlTicketsPro")
	private String urlTicketsPro;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 80)
	@Column(name = "urlTicketsPre")
	private String urlTicketsPre;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "urli2cPro")
	private String urli2cPro;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "urli2cPre")
	private String urli2cPre;
	@Basic(optional = false)
	@NotNull
	@Column(name = "numPhotosSecImg")
	private int numPhotosSecImg;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "phisicAddress1")
	private String phisicAddress1;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 60)
	@Column(name = "phisicAddress2")
	private String phisicAddress2;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "MyVerisureUrlIOS")
	private String myVerisureUrlIOS;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "MyVerisureUrlAndroid")
	private String myVerisureUrlAndroid;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "MyVerisureUrlBlackberry")
	private String myVerisureUrlBlackberry;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "MyVerisureUrlWindowsPhone")
	private String myVerisureUrlWindowsPhone;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 4)
	@Column(name = "serviceDataSystem")
	private String serviceDataSystem;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "urlBills")
	private String urlBills;
	@Basic(optional = false)
	@NotNull
	@Column(name = "hasCountryDisclamers")
	private int hasCountryDisclamers;

	public Language() {
	}

	public Language(String country) {
		this.country = country;
	}

	public Language(String country, int idlang, String description, String countrysopa, int hasDealer,
			String companyName, int daysToResetPwd, int freeSMSLimit, String fromEmailATC, String urlSopaPro,
			String urlSopaPre, String operator, String urlTicketsPro, String urlTicketsPre, String urli2cPro,
			String urli2cPre, int numPhotosSecImg, String phisicAddress1, String phisicAddress2,
			String myVerisureUrlIOS, String myVerisureUrlAndroid, String myVerisureUrlBlackberry,
			String myVerisureUrlWindowsPhone, String serviceDataSystem, String urlBills, int hasCountryDisclamers) {
		this.country = country;
		this.idlang = idlang;
		this.description = description;
		this.countrysopa = countrysopa;
		this.hasDealer = hasDealer;
		this.companyName = companyName;
		this.daysToResetPwd = daysToResetPwd;
		this.freeSMSLimit = freeSMSLimit;
		this.fromEmailATC = fromEmailATC;
		this.urlSopaPro = urlSopaPro;
		this.urlSopaPre = urlSopaPre;
		this.operator = operator;
		this.urlTicketsPro = urlTicketsPro;
		this.urlTicketsPre = urlTicketsPre;
		this.urli2cPro = urli2cPro;
		this.urli2cPre = urli2cPre;
		this.numPhotosSecImg = numPhotosSecImg;
		this.phisicAddress1 = phisicAddress1;
		this.phisicAddress2 = phisicAddress2;
		this.myVerisureUrlIOS = myVerisureUrlIOS;
		this.myVerisureUrlAndroid = myVerisureUrlAndroid;
		this.myVerisureUrlBlackberry = myVerisureUrlBlackberry;
		this.myVerisureUrlWindowsPhone = myVerisureUrlWindowsPhone;
		this.serviceDataSystem = serviceDataSystem;
		this.urlBills = urlBills;
		this.hasCountryDisclamers = hasCountryDisclamers;
	}

	public int getIdlang() {
		return this.idlang;
	}

	public void setIdlang(int idlang) {
		this.idlang = idlang;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLanguageISO() {
		return this.languageISO;
	}

	public void setLanguageISO(String languageISO) {
		this.languageISO = languageISO;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountrysopa() {
		return this.countrysopa;
	}

	public void setCountrysopa(String countrysopa) {
		this.countrysopa = countrysopa;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public Integer getDebt() {
		return this.debt;
	}

	public void setDebt(Integer debt) {
		this.debt = debt;
	}

	public Integer getAlarm() {
		return this.alarm;
	}

	public void setAlarm(Integer alarm) {
		this.alarm = alarm;
	}

	public Integer getPanelLine() {
		return this.panelLine;
	}

	public void setPanelLine(Integer panelLine) {
		this.panelLine = panelLine;
	}

	public Integer getLoginTries() {
		return this.loginTries;
	}

	public void setLoginTries(Integer loginTries) {
		this.loginTries = loginTries;
	}

	public Integer getLoginTriesNoExist() {
		return this.loginTriesNoExist;
	}

	public void setLoginTriesNoExist(Integer loginTriesNoExist) {
		this.loginTriesNoExist = loginTriesNoExist;
	}

	public Integer getMultiImg() {
		return this.multiImg;
	}

	public void setMultiImg(Integer multiImg) {
		this.multiImg = multiImg;
	}

	public String getDealerCid() {
		return this.dealerCid;
	}

	public void setDealerCid(String dealerCid) {
		this.dealerCid = dealerCid;
	}

	public Integer getGMTDifference() {
		return this.gMTDifference;
	}

	public void setGMTDifference(Integer gMTDifference) {
		this.gMTDifference = gMTDifference;
	}

	public String getCustomerCarePhoneNumber() {
		return this.customerCarePhoneNumber;
	}

	public void setCustomerCarePhoneNumber(String customerCarePhoneNumber) {
		this.customerCarePhoneNumber = customerCarePhoneNumber;
	}

	public String getWebSiteURL() {
		return this.webSiteURL;
	}

	public void setWebSiteURL(String webSiteURL) {
		this.webSiteURL = webSiteURL;
	}

	public String getVoicePortalPhoneNumber() {
		return this.voicePortalPhoneNumber;
	}

	public void setVoicePortalPhoneNumber(String voicePortalPhoneNumber) {
		this.voicePortalPhoneNumber = voicePortalPhoneNumber;
	}

	public Integer getMaxLengthNumInst() {
		return this.maxLengthNumInst;
	}

	public void setMaxLengthNumInst(Integer maxLengthNumInst) {
		this.maxLengthNumInst = maxLengthNumInst;
	}

	public String getDealer() {
		return this.dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public String getCustomerWeb() {
		return this.customerWeb;
	}

	public void setCustomerWeb(String customerWeb) {
		this.customerWeb = customerWeb;
	}

	public int getHasDealer() {
		return this.hasDealer;
	}

	public void setHasDealer(int hasDealer) {
		this.hasDealer = hasDealer;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCurrencyCost() {
		return this.currencyCost;
	}

	public void setCurrencyCost(String currencyCost) {
		this.currencyCost = currencyCost;
	}

	public Integer getFreeImageRequest() {
		return this.freeImageRequest;
	}

	public void setFreeImageRequest(Integer freeImageRequest) {
		this.freeImageRequest = freeImageRequest;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTax() {
		return this.tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getCountryTickets() {
		return this.countryTickets;
	}

	public void setCountryTickets(String countryTickets) {
		this.countryTickets = countryTickets;
	}

	public int getDaysToResetPwd() {
		return this.daysToResetPwd;
	}

	public void setDaysToResetPwd(int daysToResetPwd) {
		this.daysToResetPwd = daysToResetPwd;
	}

	public int getFreeSMSLimit() {
		return this.freeSMSLimit;
	}

	public void setFreeSMSLimit(int freeSMSLimit) {
		this.freeSMSLimit = freeSMSLimit;
	}

	public String getFromEmailATC() {
		return this.fromEmailATC;
	}

	public void setFromEmailATC(String fromEmailATC) {
		this.fromEmailATC = fromEmailATC;
	}

	public String getUrlSopaPro() {
		return this.urlSopaPro;
	}

	public void setUrlSopaPro(String urlSopaPro) {
		this.urlSopaPro = urlSopaPro;
	}

	public String getUrlSopaPre() {
		return this.urlSopaPre;
	}

	public void setUrlSopaPre(String urlSopaPre) {
		this.urlSopaPre = urlSopaPre;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getUrlTicketsPro() {
		return this.urlTicketsPro;
	}

	public void setUrlTicketsPro(String urlTicketsPro) {
		this.urlTicketsPro = urlTicketsPro;
	}

	public String getUrlTicketsPre() {
		return this.urlTicketsPre;
	}

	public void setUrlTicketsPre(String urlTicketsPre) {
		this.urlTicketsPre = urlTicketsPre;
	}

	public String getUrli2cPro() {
		return this.urli2cPro;
	}

	public void setUrli2cPro(String urli2cPro) {
		this.urli2cPro = urli2cPro;
	}

	public String getUrli2cPre() {
		return this.urli2cPre;
	}

	public void setUrli2cPre(String urli2cPre) {
		this.urli2cPre = urli2cPre;
	}

	public int getNumPhotosSecImg() {
		return this.numPhotosSecImg;
	}

	public void setNumPhotosSecImg(int numPhotosSecImg) {
		this.numPhotosSecImg = numPhotosSecImg;
	}

	public String getPhisicAddress1() {
		return this.phisicAddress1;
	}

	public void setPhisicAddress1(String phisicAddress1) {
		this.phisicAddress1 = phisicAddress1;
	}

	public String getPhisicAddress2() {
		return this.phisicAddress2;
	}

	public void setPhisicAddress2(String phisicAddress2) {
		this.phisicAddress2 = phisicAddress2;
	}

	public String getMyVerisureUrlIOS() {
		return this.myVerisureUrlIOS;
	}

	public void setMyVerisureUrlIOS(String myVerisureUrlIOS) {
		this.myVerisureUrlIOS = myVerisureUrlIOS;
	}

	public String getMyVerisureUrlAndroid() {
		return this.myVerisureUrlAndroid;
	}

	public void setMyVerisureUrlAndroid(String myVerisureUrlAndroid) {
		this.myVerisureUrlAndroid = myVerisureUrlAndroid;
	}

	public String getMyVerisureUrlBlackberry() {
		return this.myVerisureUrlBlackberry;
	}

	public void setMyVerisureUrlBlackberry(String myVerisureUrlBlackberry) {
		this.myVerisureUrlBlackberry = myVerisureUrlBlackberry;
	}

	public String getMyVerisureUrlWindowsPhone() {
		return this.myVerisureUrlWindowsPhone;
	}

	public void setMyVerisureUrlWindowsPhone(String myVerisureUrlWindowsPhone) {
		this.myVerisureUrlWindowsPhone = myVerisureUrlWindowsPhone;
	}

	public String getServiceDataSystem() {
		return this.serviceDataSystem;
	}

	public void setServiceDataSystem(String serviceDataSystem) {
		this.serviceDataSystem = serviceDataSystem;
	}

	public String getUrlBills() {
		return this.urlBills;
	}

	public void setUrlBills(String urlBills) {
		this.urlBills = urlBills;
	}

	public int getHasCountryDisclamers() {
		return this.hasCountryDisclamers;
	}

	public void setHasCountryDisclamers(int hasCountryDisclamers) {
		this.hasCountryDisclamers = hasCountryDisclamers;
	}

	public int hashCode() {
		int hash = 0;
		hash += (this.country != null) ? this.country.hashCode() : 0;
		return hash;
	}

	public boolean equals(Object object) {
		if (!(object instanceof com.securitasdirect.sessions.entity.Language)) {
			return false;
		}
		com.securitasdirect.sessions.entity.Language other = (com.securitasdirect.sessions.entity.Language) object;
		if ((this.country == null && other.country != null)
				|| (this.country != null && !this.country.equals(other.country))) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "com.securitasdirect.wsusersinstaut.entity.Language[ country=" + this.country + " ]";
	}
}
