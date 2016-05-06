/**
 * GetUserInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bigmachines.soap;

public class GetUserInfoResponse  implements java.io.Serializable {
    private com.bigmachines.soap.CommonStatusType status;

    private com.bigmachines.soap.UserType userInfo;

    public GetUserInfoResponse() {
    }

    public GetUserInfoResponse(
           com.bigmachines.soap.CommonStatusType status,
           com.bigmachines.soap.UserType userInfo) {
           this.status = status;
           this.userInfo = userInfo;
    }


    /**
     * Gets the status value for this GetUserInfoResponse.
     * 
     * @return status
     */
    public com.bigmachines.soap.CommonStatusType getStatus() {
        return status;
    }


    /**
     * Sets the status value for this GetUserInfoResponse.
     * 
     * @param status
     */
    public void setStatus(com.bigmachines.soap.CommonStatusType status) {
        this.status = status;
    }


    /**
     * Gets the userInfo value for this GetUserInfoResponse.
     * 
     * @return userInfo
     */
    public com.bigmachines.soap.UserType getUserInfo() {
        return userInfo;
    }


    /**
     * Sets the userInfo value for this GetUserInfoResponse.
     * 
     * @param userInfo
     */
    public void setUserInfo(com.bigmachines.soap.UserType userInfo) {
        this.userInfo = userInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetUserInfoResponse)) return false;
        GetUserInfoResponse other = (GetUserInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.userInfo==null && other.getUserInfo()==null) || 
             (this.userInfo!=null &&
              this.userInfo.equals(other.getUserInfo())));
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
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getUserInfo() != null) {
            _hashCode += getUserInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetUserInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">getUserInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "CommonStatusType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "userInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "UserType"));
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
