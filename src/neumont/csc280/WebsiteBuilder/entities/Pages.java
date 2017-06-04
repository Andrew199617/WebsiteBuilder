package neumont.csc280.WebsiteBuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="pages")
public class Pages {
	@Id
	@Column(name="Page_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pageId;
}
