package neumont.csc280.WebsiteBuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="pages")
public class Page {
	
	@Id
	@Column(name="page_id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pageId;
	
	@Column(name="name", unique = true, nullable=true)
	private String name;
	
	@Column(name="templateNum", nullable=true)
	private String templateNum;
	
	@Column(name="missionStatement", nullable=true)
	private String missionStatement;
	
	@Column(name="history", nullable=true)
	private String history;
	
	@Column(name="title", nullable=true)
	private String title;
	
	@Column(name="description", nullable=true)
	private String description;
	
	@Column(name="address", nullable=true)
	private String address;
	
	@Column(name="SuccessStory", nullable=true)
	private String successStory;
	
	@Column(name="SuccessDescription", nullable=true)
	private String successDescription;
	
	@Column(name="JobTitle", nullable=true)
	private String jobTitle;
	
	@Column(name="JobDescription", nullable=true)
	private String jobDescription;
	
	@Column(name="FAQQuestion", nullable=true)
	private String FAQQuestion;
	
	@Column(name="FAQAnswer", nullable=true)
	private String FAQAnswer;
	
	@Column(name="profileName", nullable=true)
	private String profileName;
	
	@Column(name="bio", nullable=true)
	private String bio;
	
	@Column(name="email", nullable=true)
	private String email;
	
	

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	private User owner;
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMissionStatement() {
		return missionStatement;
	}

	public void setMissionStatement(String missionStatement) {
		this.missionStatement = missionStatement;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSuccessStory() {
		return successStory;
	}

	public void setSuccessStory(String successStory) {
		this.successStory = successStory;
	}

	public String getSuccessDescription() {
		return successDescription;
	}

	public void setSuccessDescription(String successDescription) {
		this.successDescription = successDescription;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getFAQQuestion() {
		return FAQQuestion;
	}

	public void setFAQQuestion(String fAQQuestion) {
		FAQQuestion = fAQQuestion;
	}

	public String getFAQAnswer() {
		return FAQAnswer;
	}

	public void setFAQAnswer(String fAQAnswer) {
		FAQAnswer = fAQAnswer;
	}

	public String getTemplateNum() {
		return templateNum;
	}

	public void setTemplateNum(String templateNum) {
		this.templateNum = templateNum;
	}
	
}
