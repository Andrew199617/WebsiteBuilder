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
