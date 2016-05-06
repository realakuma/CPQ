/**
 * SecurityService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bigmachines.soap;

public interface SecurityService extends javax.xml.rpc.Service {
    public java.lang.String getSecurityServicePortAddress();

    public com.bigmachines.soap.SecurityServicePortType getSecurityServicePort() throws javax.xml.rpc.ServiceException;

    public com.bigmachines.soap.SecurityServicePortType getSecurityServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
