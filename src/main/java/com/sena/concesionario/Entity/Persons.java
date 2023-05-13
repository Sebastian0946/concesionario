package com.sena.concesionario.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "personas")
public class Persons {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "document_type", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "string")
	private TipoDocumentoEnum documentType;

	@Column(name = "document", nullable = false, length = 12)
	private String document;

	@Column(name = "first_name", nullable = false, length = 45)
	private String firstName;

	@Column(name = "second_name", nullable = true, length = 45)
	private String secondName;

	@Column(name = "surname", nullable = false, length = 45)
	private String surName;

	@Column(name = "second_surname", nullable = true, length = 45)
	private String secondSurname;

	@Column(name = "age", nullable = false, length = 3)
	private byte age;

	@Column(name = "gender", nullable = false, length = 3)
	private GenderEnum gender;

	@Column(name = "email", nullable = true, length = 45)
	private String email;

	@Column(name = "phone", nullable = true, length = 15)
	private String phone;

	@Column(name = "address", nullable = true, length = 45)
	private String address;

	@Column(name = "state", nullable = false)
	private StateEnum state;

	@Column(name = "user_creation", nullable = false)
	private int userCreation;

	@Column(name = "user_modification", nullable = true)
	private int userModification;

	@Column(name = "Creation_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date creationDate;

	@Column(name = "modification_date", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date modificationDate;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoDocumentoEnum getDocumentType() {
		return documentType;
	}

	public void setDocumentType(TipoDocumentoEnum documentType) {
		this.documentType = documentType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}


	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}

	public int getUserCreation() {
		return userCreation;
	}

	public void setUserCreation(int userCreation) {
		this.userCreation = userCreation;
	}

	public int getUserModification() {
		return userModification;
	}

	public void setUserModification(int userModification) {
		this.userModification = userModification;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public enum TipoDocumentoEnum {
		CC("CC"), TI("TI");

		private final String codigo;

		TipoDocumentoEnum(String codigo) {
			this.codigo = codigo;
		}

		public String getCodigo() {
			return codigo;
		}

		public static TipoDocumentoEnum fromCode(String codigo) {
			for (TipoDocumentoEnum tipoDocumento : TipoDocumentoEnum.values()) {
				if (tipoDocumento.getCodigo().equalsIgnoreCase(codigo)) {
					return tipoDocumento;
				}
			}
			return null;
		}
	}
	
	public enum GenderEnum {
		M("Masculino"), F("Femenino");

		private final String codigo;

		GenderEnum(String codigo) {
			this.codigo = codigo;
		}

		public String getCodigo() {
			return codigo;
		}

		public static GenderEnum fromCode(String codigo) {
			for (GenderEnum gender : GenderEnum.values()) {
				if (gender.getCodigo().equalsIgnoreCase(codigo)) {
					return gender;
				}
			}
			return null;
		}
	}
	
	public enum StateEnum{
		Activo("true"), Inactivo("false");

		private final String codigo;

		StateEnum(String codigo) {
			this.codigo = codigo;
		}

		public String getCodigo() {
			return codigo;
		}

		public static StateEnum fromCode(String codigo) {
			for (StateEnum state : StateEnum.values()) {
				if (state.getCodigo().equalsIgnoreCase(codigo)) {
					return state;
				}
			}
			return null;
		}
	}
}
