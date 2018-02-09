package cn.itcast.invoice.auth.emp.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cn.itcast.invoice.auth.dep.vo.DepModel;
import cn.itcast.invoice.auth.role.vo.RoleModel;
import cn.itcast.invoice.util.format.FormatUtil;

public class EmpModel {
	public static final Integer EMP_GENDER_OF_MAN = 1;
	public static final Integer EMP_GENDER_OF_WOMAN = 0;
	
	public static final String EMP_GENDER_OF_MAN_VIEW = "ç”·";
	public static final String EMP_GENDER_OF_WOMAN_VIEW = "å¥³";
	
	public static Map<Integer, String> genderMap = new HashMap<Integer, String>();
	
	static{
		genderMap.put(EMP_GENDER_OF_MAN, EMP_GENDER_OF_MAN_VIEW);
		genderMap.put(EMP_GENDER_OF_WOMAN, EMP_GENDER_OF_WOMAN_VIEW);
	}
	
	private Long uuid;
	//ç™»é™†ç”¨æˆ·å��
	private String userName;
	//å¯†ç �
	private String pwd;
	//çœŸå®žå§“å��
	private String name;
	
	private String email;
	private String tele;
	private String address;
	private String lastLoginIp;
	
	private Long birthday;
	private Long lastLoginTime;

	private Integer gender;
	private Integer loginTimes;
	
	//è§†å›¾å€¼
	private String birthdayView;
	private String lastLoginTimeView;
	private String genderView;
	
	//å…³ç³»
	private DepModel dm;
	private Set<RoleModel> roles;
	
	//æ�ƒé™�æ ¡éªŒè¾…åŠ©å­—æ®µ
	private String resValue;
	
	public String getResValue() {
		return resValue;
	}

	public void setResValue(String resValue) {
		this.resValue = resValue;
	}

	public Set<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleModel> roles) {
		this.roles = roles;
	}

	public Long getUuid() {
		return uuid;
	}

	/**
	 * 
	 * @param check insert 0 to get birthdayView, 1 to get genderView, 2 to get lastLoginTimeView
	 * @return a string with the desidered value
	 */
	public String getView(int check) {
		String toReturn = null;
		if (check == 0) {
			toReturn= birthdayView;
		}
		if (check == 1) {
			toReturn= genderView;
		}
		if (check == 2) {
			toReturn =lastLoginTimeView;
		}
			
		return toReturn;
	}
	

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * 
	 * @param check insert 0 to get name, 1 to get email, 2 to get tele, 3 to get address
	 * @return a string with the desidered value
	 */
	public String getPersonalInformation(int check) {
		String toReturn = null;
		if (check == 0) {
			toReturn= name;
		} else
		if (check == 1) {
			toReturn= email;
		} else
		if (check == 2) {
			toReturn =tele;
		}else
		if (check == 3) {
			toReturn =address;
		} else {
			toReturn = "The Value is not correct, please read documentation!";
		}
			
		return toReturn;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Long getBirthday() {
		return birthday;
	}

	public void setBirthday(Long birthday) {
		this.birthday = birthday;
		this.birthdayView = FormatUtil.formatDate(birthday);
	}

	public Long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
		this.lastLoginTimeView = FormatUtil.formatDate(lastLoginTime);
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
		this.genderView = genderMap.get(gender);
	}

	public Integer getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}

	public DepModel getDm() {
		return dm;
	}

	public void setDm(DepModel dm) {
		this.dm = dm;
	}
	
}
