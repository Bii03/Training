package json;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Info {
	
	@Override
	public String toString() {
		return "Info [title=" + title + ", license=" + license + ", contact="
				+ contact + ", licenseUrl=" + licenseUrl
				+ ", termsOfServiceUrl=" + termsOfServiceUrl + ", description="
				+ description + "]";
	}
	private String title;
	private String license;
	private String contact;
	private String licenseUrl;
	private String termsOfServiceUrl;
	private String description;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getLicenseUrl() {
		return licenseUrl;
	}
	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}
	public String getTermsOfServiceUrl() {
		return termsOfServiceUrl;
	}
	public void setTermsOfServiceUrl(String termsOfServiceUrl) {
		this.termsOfServiceUrl = termsOfServiceUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
