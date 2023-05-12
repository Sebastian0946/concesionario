package com.sena.concesionario.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "vistas")
public class Views {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@ManyToOne (fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "modules_id", unique = true,  nullable = false)
    private Modules modulesId;
	
	@Column(name = "route", nullable = false, length = 150)
    private String route;

    @Column(name = "labeled", nullable = false,  length = 100)
    private String labeled;
    
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


	public Modules getModulesId() {
		return modulesId;
	}

	public void setModulesId(Modules modulesId) {
		this.modulesId = modulesId;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getLabeled() {
		return labeled;
	}

	public void setLabeled(String labeled) {
		this.labeled = labeled;
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
