package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="prdTab1")
@Data
public class Product {
	@Id
	@GeneratedValue
	@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
	private int id;
	@Column(name="prdname")
	private String prdName;
	@Column(name="prdprice")
	private String prdPrice;
	@Column(name="prdqty")
	private String prdQty;
	@Column(name="filename")
	private String fileName;
	@Column(name="file22")
	@Lob
	private byte[] file;
	
}
