package crxy.stat.hadoop.mr;

public class AccessLog {

	

	public AccessLog(Integer appId, String ip, String mid,
			Integer userId, Integer loginType, String request, Integer status,
			String httpReferer, String userAgent, Long time) {
		this.appId = appId;
		this.ip = ip;
		this.mid = mid;
		this.userId = userId;
		this.loginType = loginType;
		this.request = request;
		this.status = status;
		this.httpReferer = httpReferer;
		this.userAgent = userAgent;
		this.time = time;
	}
	
	
	private Integer appId;
	private String ip;	
	private String provice;
	private String city;
	
	
	private String mid;	
	private Integer userId;	
	private Integer loginType;	
	
	private String request;	
	private String method;
	private String path;
	private String httpVersion;
	
	private Integer status;	
	private String httpReferer;	
	private String userAgent;	
	private String ieType;
	
	private Long time;
	private String dateTIme;
	@Override
	public String toString() {
		return appId + "\t" + ip + "\t" + provice + "\t" + city + "\t" + mid
				+ "\t" + userId + "\t" + loginType + "\t" + request + "\t"
				+ method + "\t" + path + "\t" + httpVersion + "\t" + status
				+ "\t" + httpReferer + "\t" + userAgent + "\t" + ieType + "\t"
				+ time + "\t" + dateTIme;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getProvice() {
		return provice;
	}
	public void setProvice(String provice) {
		this.provice = provice;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getLoginType() {
		return loginType;
	}
	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getHttpVersion() {
		return httpVersion;
	}
	public void setHttpVersion(String httpVersion) {
		this.httpVersion = httpVersion;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getHttpReferer() {
		return httpReferer;
	}
	public void setHttpReferer(String httpReferer) {
		this.httpReferer = httpReferer;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getIeType() {
		return ieType;
	}
	public void setIeType(String ieType) {
		this.ieType = ieType;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getDateTIme() {
		return dateTIme;
	}
	public void setDateTIme(String dateTIme) {
		this.dateTIme = dateTIme;
	}

	
	
	
	
}
