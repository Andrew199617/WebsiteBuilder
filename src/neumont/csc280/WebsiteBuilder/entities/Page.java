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
	
	@Column(name="name", nullable=true)
	private String name;
	
	@Column(name="missionStatement", nullable=true)
	private String missionStatement;
	
	@Column(name="history", nullable=true)
	private String history;
	
	@Column(name="firstTemplateTitle", nullable=true)
	private String firstTemplateTitle;
	
	@Column(name="secondTemplateTitle", nullable=true)
	private String secondTemplateTitle;
	
	@Column(name="firstTemplateDescription", nullable=true)
	private String firstTemplateDescription;
	
	@Column(name="secondTemplateDescription", nullable=true)
	private String secondTemplateDescription;
	
	@Column(name="address", nullable=true)
	private String address;
	
	@Column(name="firstSuccessStory", nullable=true)
	private String firstSuccessStory;
	
	@Column(name="firstSuccessDescription", nullable=true)
	private String firstSuccessDescription;
	
	@Column(name="secondSuccessStory", nullable=true)
	private String secondSuccessStory;
	
	@Column(name="secondSuccessDescription", nullable=true)
	private String secondSuccessDescription;
	
	@Column(name="firstJobTitle", nullable=true)
	private String firstJobTitle;
	
	@Column(name="firstJobDescription", nullable=true)
	private String firstJobDescription;
	
	@Column(name="secondJobTitle", nullable=true)
	private String secondJobTitle;
	
	@Column(name="secondJobDescription", nullable=true)
	private String secondJobDescription;
	
	@Column(name="thirdTemplateTitle", nullable=true)
	private String thirdTemplateTitle;
	
	@Column(name="thirdTemplateDescription", nullable=true)
	private String thirdTemplateDescription;
	
	@Column(name="firstFAQQuestion", nullable=true)
	private String firstFAQQuestion;
	
	@Column(name="firstFAQAnswer", nullable=true)
	private String firstFAQAnswer;
	
	@Column(name="secondFAQQuestion", nullable=true)
	private String secondFAQQuestion;
	
	@Column(name="secondFAQAnswer", nullable=true)
	private String secondFAQAnswer;
	
	@Column(name="thirdFAQQuestion", nullable=true)
	private String thirdFAQQuestion;
	
	@Column(name="thirdFAQAnswer", nullable=true)
	private String thirdFAQAnswer;
	
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

	public String getFirstFAQQuestion() {
		return firstFAQQuestion;
	}

	public void setFirstFAQQuestion(String firstFAQQuestion) {
		this.firstFAQQuestion = firstFAQQuestion;
	}

	public String getFirstFAQAnswer() {
		return firstFAQAnswer;
	}

	public void setFirstFAQAnswer(String firstFAQAnswer) {
		this.firstFAQAnswer = firstFAQAnswer;
	}

	public String getSecondFAQQuestion() {
		return secondFAQQuestion;
	}

	public void setSecondFAQQuestion(String secondFAQQuestion) {
		this.secondFAQQuestion = secondFAQQuestion;
	}

	public String getSecondFAQAnswer() {
		return secondFAQAnswer;
	}

	public void setSecondFAQAnswer(String secondFAQAnswer) {
		this.secondFAQAnswer = secondFAQAnswer;
	}

	public String getThirdFAQQuestion() {
		return thirdFAQQuestion;
	}

	public void setThirdFAQQuestion(String thirdFAQQuestion) {
		this.thirdFAQQuestion = thirdFAQQuestion;
	}

	public String getThirdFAQAnswer() {
		return thirdFAQAnswer;
	}

	public void setThirdFAQAnswer(String thirdFAQAnswer) {
		this.thirdFAQAnswer = thirdFAQAnswer;
	}

	public String getThirdTemplateTitle() {
		return thirdTemplateTitle;
	}

	public void setThirdTemplateTitle(String thirdTemplateTitle) {
		this.thirdTemplateTitle = thirdTemplateTitle;
	}

	public String getThirdTemplateDescription() {
		return thirdTemplateDescription;
	}

	public void setThirdTemplateDescription(String thirdTemplateDescription) {
		this.thirdTemplateDescription = thirdTemplateDescription;
	}

	public String getFirstJobTitle() {
		return firstJobTitle;
	}

	public void setFirstJobTitle(String firstJobTitle) {
		this.firstJobTitle = firstJobTitle;
	}

	public String getFirstJobDescription() {
		return firstJobDescription;
	}

	public void setFirstJobDescription(String firstJobDescription) {
		this.firstJobDescription = firstJobDescription;
	}

	public String getSecondJobTitle() {
		return secondJobTitle;
	}

	public void setSecondJobTitle(String secondJobTitle) {
		this.secondJobTitle = secondJobTitle;
	}

	public String getSecondJobDescription() {
		return secondJobDescription;
	}

	public void setSecondJobDescription(String secondJobDescription) {
		this.secondJobDescription = secondJobDescription;
	}

	public String getFirstSuccessStory() {
		return firstSuccessStory;
	}

	public void setFirstSuccessStory(String firstSuccessStory) {
		this.firstSuccessStory = firstSuccessStory;
	}

	public String getFirstSuccessDescription() {
		return firstSuccessDescription;
	}

	public void setFirstSuccessDescription(String firstSuccessDescription) {
		this.firstSuccessDescription = firstSuccessDescription;
	}

	public String getSecondSuccessStory() {
		return secondSuccessStory;
	}

	public void setSecondSuccessStory(String secondSuccessStory) {
		this.secondSuccessStory = secondSuccessStory;
	}

	public String getSecondSuccessDescription() {
		return secondSuccessDescription;
	}

	public void setSecondSuccessDescription(String secondSuccessDescription) {
		this.secondSuccessDescription = secondSuccessDescription;
	}

	public String getAddress() {
		return address;
	}

	public String getSecondTemplateDescription() {
		return secondTemplateDescription;
	}

	public void setSecondTemplateDescription(String secondTemplateDescription) {
		this.secondTemplateDescription = secondTemplateDescription;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getSecondTemplateTitle() {
		return secondTemplateTitle;
	}

	public void setSecondTemplateTitle(String secondTemplateTitle) {
		this.secondTemplateTitle = secondTemplateTitle;
	}

	public String getFirstTemplateDescription() {
		return firstTemplateDescription;
	}

	public void setFirstTemplateDescription(String firstTemplateDescription) {
		this.firstTemplateDescription = firstTemplateDescription;
	}

	public String getFirstTemplateTitle() {
		return firstTemplateTitle;
	}

	public void setFirstTemplateTitle(String firstTemplateTitle) {
		this.firstTemplateTitle = firstTemplateTitle;
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
	
}
