package com.spdb.training.socket.trans.or02;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/** 
* @author 作者: 王腾蛟
* @version time：2019年6月19日 上午10:20:56 
*   类说明:
*/
@XmlType(propOrder= {"globalSeq","transSeq","transDate","name","age","telNo"})
public class ReqOR02ServiceBody {

	@XmlElement(name="globalSeq")
	private String globalSeq;
	@XmlElement(name="transSeq")
	private String transSeq;
	@XmlElement(name="transDate")
	private String transDate;
	@XmlElement(name="name")
	private String name;
	@XmlElement(name="age")
	private Integer age;
	@XmlElement(name="telNo")
	private String telNo;
	
	@XmlTransient  
	public String getGlobalSeq() {
		return globalSeq;
	}
	public void setGlobalSeq(String globalSeq) {
		this.globalSeq = globalSeq;
	}
	@XmlTransient  
	public String getTransSeq() {
		return transSeq;
	}
	public void setTransSeq(String transSeq) {
		this.transSeq = transSeq;
	}
	@XmlTransient  
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	@XmlTransient  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlTransient  
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@XmlTransient  
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	
	
}
