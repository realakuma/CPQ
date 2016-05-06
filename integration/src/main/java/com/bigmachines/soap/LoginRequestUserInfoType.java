/**
 * LoginRequestUserInfoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bigmachines.soap;

public class LoginRequestUserInfoType  implements java.io.Serializable {
    private java.lang.String username;

    private java.lang.String password;

    private java.lang.String sessionCurrency;

    private com.bigmachines.soap.BooleanOrBlank sso;

    public LoginRequestUserInfoType() {
    }

    public LoginRequestUserInfoType(
           java.lang.String username,
           java.lang.String password,
           java.lang.String sessionCurrency,
           com.bigmachines.soap.BooleanOrBlank sso) {
           this.username = username;
           this.password = password;
           this.sessionCurrency = sessionCurrency;
           this.sso = sso;
    }


    /**
     * Gets the username value for this LoginRequestUserInfoType.
     * 
     * @return username
     */
    public java.lang.String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this LoginRequestUserInfoType.
     * 
     * @param username
     */
    public void setUsername(java.lang.String username) {
        this.username = username;
    }


    /**
     * Gets the password value for this LoginRequestUserInfoType.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this LoginRequestUserInfoType.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the sessionCurrency value for this LoginRequestUserInfoType.
     * 
     * @return sessionCurrency
     */
    public java.lang.String getSessionCurrency() {
        return sessionCurrency;
    }


    /**
     * Sets the sessionCurrency value for this LoginRequestUserInfoType.
     * 
     * @param sessionCurrency
     */
    public void setSessionCurrency(java.lang.String sessionCurrency) {
        this.sessionCurrency = sessionCurrency;
    }


    /**
     * Gets the sso value for this LoginRequestUserInfoType.
     * 
     * @return sso
     */
    public com.bigmachines.soap.BooleanOrBlank getSso() {
        return sso;
    }


    /**
     * Sets the sso value for this LoginRequestUserInfoType.
     * 
     * @param sso
     */
    public void setSso(com.bigmachines.soap.BooleanOrBlank sso) {
        this.sso = sso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LoginRequestUserInfoType)) return false;
        LoginRequestUserInfoType other = (LoginRequestUserInfoType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.username==null && other.getUsername()==null) || 
             (this.username!=null &&
              this.username.equals(other.getUsername()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.sessionCurrency==null && other.getSessionCurrency()==null) || 
             (this.sessionCurrency!=null &&
              this.sessionCurrency.equals(other.getSessionCurrency()))) &&
            ((this.sso==null && other.getSso()==null) || 
             (this.sso!=null &&
              this.sso.equals(other.getSso())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getSessionCurrency() != null) {
            _hashCode += getSessionCurrency().hashCode();
        }
        if (getSso() != null) {
            _hashCode += getSso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LoginRequestUserInfoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "LoginRequestUserInfoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "username"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionCurrency");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "sessionCurrency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sso");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "sso"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "BooleanOrBlank"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
