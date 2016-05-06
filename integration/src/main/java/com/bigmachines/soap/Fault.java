/**
 * Fault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bigmachines.soap;

public class Fault  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    private java.lang.String exceptionCode;

    private java.lang.String exceptionMessage;

    private java.lang.String exceptionDescription;

    public Fault() {
    }

    public Fault(
           java.lang.String exceptionCode,
           java.lang.String exceptionMessage,
           java.lang.String exceptionDescription) {
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
        this.exceptionDescription = exceptionDescription;
    }


    /**
     * Gets the exceptionCode value for this Fault.
     * 
     * @return exceptionCode
     */
    public java.lang.String getExceptionCode() {
        return exceptionCode;
    }


    /**
     * Sets the exceptionCode value for this Fault.
     * 
     * @param exceptionCode
     */
    public void setExceptionCode(java.lang.String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }


    /**
     * Gets the exceptionMessage value for this Fault.
     * 
     * @return exceptionMessage
     */
    public java.lang.String getExceptionMessage() {
        return exceptionMessage;
    }


    /**
     * Sets the exceptionMessage value for this Fault.
     * 
     * @param exceptionMessage
     */
    public void setExceptionMessage(java.lang.String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }


    /**
     * Gets the exceptionDescription value for this Fault.
     * 
     * @return exceptionDescription
     */
    public java.lang.String getExceptionDescription() {
        return exceptionDescription;
    }


    /**
     * Sets the exceptionDescription value for this Fault.
     * 
     * @param exceptionDescription
     */
    public void setExceptionDescription(java.lang.String exceptionDescription) {
        this.exceptionDescription = exceptionDescription;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Fault)) return false;
        Fault other = (Fault) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.exceptionCode==null && other.getExceptionCode()==null) || 
             (this.exceptionCode!=null &&
              this.exceptionCode.equals(other.getExceptionCode()))) &&
            ((this.exceptionMessage==null && other.getExceptionMessage()==null) || 
             (this.exceptionMessage!=null &&
              this.exceptionMessage.equals(other.getExceptionMessage()))) &&
            ((this.exceptionDescription==null && other.getExceptionDescription()==null) || 
             (this.exceptionDescription!=null &&
              this.exceptionDescription.equals(other.getExceptionDescription())));
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
        if (getExceptionCode() != null) {
            _hashCode += getExceptionCode().hashCode();
        }
        if (getExceptionMessage() != null) {
            _hashCode += getExceptionMessage().hashCode();
        }
        if (getExceptionDescription() != null) {
            _hashCode += getExceptionDescription().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Fault.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">fault"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exceptionCode");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "exceptionCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exceptionMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "exceptionMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exceptionDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "exceptionDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
