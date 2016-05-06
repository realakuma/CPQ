/**
 * SecurityServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bigmachines.soap;

public interface SecurityServicePortType extends java.rmi.Remote {
    public com.bigmachines.soap.GetUserInfoResponse getUserInfo(java.lang.Object getUserInfo) throws java.rmi.RemoteException, com.bigmachines.soap.Fault;
    public com.bigmachines.soap.LoginResponse login(com.bigmachines.soap.Login login) throws java.rmi.RemoteException, com.bigmachines.soap.Fault;
    public com.bigmachines.soap.LogoutResponse logout(java.lang.Object logout) throws java.rmi.RemoteException, com.bigmachines.soap.Fault;
    public com.bigmachines.soap.SetSessionCurrencyResponse setSessionCurrency(com.bigmachines.soap.SetSessionCurrency setSessionCurrency) throws java.rmi.RemoteException, com.bigmachines.soap.Fault;
}
