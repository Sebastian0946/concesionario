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




@Entity
@Table(name = "roles")
public class Roles {
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(name = "code", nullable = true)
	    private String code;

	    @Column(name = "description", nullable = false, length = 45)
	    private String description;

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



		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
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
