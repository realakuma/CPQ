/**
 * LoginResponseUserInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bigmachines.soap;

public class LoginResponseUserInfo  implements java.io.Serializable {
    private java.lang.String sessionCurrency;

    private java.lang.String sessionId;

    private org.apache.axis.types.URI actor;  // attribute

    private java.lang.Boolean mustUnderstand;  // attribute

    public LoginResponseUserInfo() {
    }

    public LoginResponseUserInfo(
           java.lang.String sessionCurrency,
           java.lang.String sessionId,
           org.apache.axis.types.URI actor,
           java.lang.Boolean mustUnderstand) {
           this.sessionCurrency = sessionCurrency;
           this.sessionId = sessionId;
           this.actor = actor;
           this.mustUnderstand = mustUnderstand;
    }


    /**
     * Gets the sessionCurrency value for this LoginResponseUserInfo.
     * 
     * @return sessionCurrency
     */
    public java.lang.String getSessionCurrency() {
        return sessionCurrency;
    }


    /**
     * Sets the sessionCurrency value for this LoginResponseUserInfo.
     * 
     * @param sessionCurrency
     */
    public void setSessionCurrency(java.lang.String sessionCurrency) {
        this.sessionCurrency = sessionCurrency;
    }


    /**
     * Gets the sessionId value for this LoginResponseUserInfo.
     * 
     * @return sessionId
     */
    public java.lang.String getSessionId() {
        return sessionId;
    }


    /**
     * Sets the sessionId value for this LoginResponseUserInfo.
     * 
     * @param sessionId
     */
    public void setSessionId(java.lang.String sessionId) {
        this.sessionId = sessionId;
    }


    /**
     * Gets the actor value for this LoginResponseUserInfo.
     * 
     * @return actor
     */
    public org.apache.axis.types.URI getActor() {
        return actor;
    }


    /**
     * Sets the actor value for this LoginResponseUserInfo.
     * 
     * @param actor
     */
    public void setActor(org.apache.axis.types.URI actor) {
        this.actor = actor;
    }


    /**
     * Gets the mustUnderstand value for this LoginResponseUserInfo.
     * 
     * @return mustUnderstand
     */
    public java.lang.Boolean getMustUnderstand() {
        return mustUnderstand;
    }


    /**
     * Sets the mustUnderstand value for this LoginResponseUserInfo.
     * 
     * @param mustUnderstand
     */
    public void setMustUnderstand(java.lang.Boolean mustUnderstand) {
        this.mustUnderstand = mustUnderstand;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LoginResponseUserInfo)) return false;
        LoginResponseUserInfo other = (LoginResponseUserInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.sessionCurrency==null && other.getSessionCurrency()==null) || 
             (this.sessionCurrency!=null &&
              this.sessionCurrency.equals(other.getSessionCurrency()))) &&
            ((this.sessionId==null && other.getSessionId()==null) || 
             (this.sessionId!=null &&
              this.sessionId.equals(other.getSessionId()))) &&
            ((this.actor==null && other.getActor()==null) || 
             (this.actor!=null &&
              this.actor.equals(other.getActor()))) &&
            ((this.mustUnderstand==null && other.getMustUnderstand()==null) || 
             (this.mustUnderstand!=null &&
              this.mustUnderstand.equals(other.getMustUnderstand())));
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
        if (getSessionCurrency() != null) {
            _hashCode += getSessionCurrency().hashCode();
        }
        if (getSessionId() != null) {
            _hashCode += getSessionId().hashCode();
        }
        if (getActor() != null) {
            _hashCode += getActor().hashCode();
        }
        if (getMustUnderstand() != null) {
            _hashCode += getMustUnderstand().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LoginResponseUserInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "LoginResponseUserInfo"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("actor");
        attrField.setXmlName(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", "actor"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"));
        typeDesc.addFieldDesc(attrField);
        attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("mustUnderstand");
        attrField.setXmlName(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", "mustUnderstand"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">mustUnderstand"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionCurrency");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "sessionCurrency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sessionId");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "sessionId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
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
