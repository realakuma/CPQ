package com.bigmachines.soap;

public class SecurityServicePortTypeProxy implements com.bigmachines.soap.SecurityServicePortType {
  private String _endpoint = null;
  private com.bigmachines.soap.SecurityServicePortType securityServicePortType = null;
  
  public SecurityServicePortTypeProxy() {
    _initSecurityServicePortTypeProxy();
  }
  
  public SecurityServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initSecurityServicePortTypeProxy();
  }
  
  private void _initSecurityServicePortTypeProxy() {
    try {
      securityServicePortType = (new com.bigmachines.soap.SecurityServiceLocator()).getSecurityServicePort();
      if (securityServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)securityServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)securityServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (securityServicePortType != null)
      ((javax.xml.rpc.Stub)securityServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.bigmachines.soap.SecurityServicePortType getSecurityServicePortType() {
    if (securityServicePortType == null)
      _initSecurityServicePortTypeProxy();
    return securityServicePortType;
  }
  
  public com.bigmachines.soap.GetUserInfoResponse getUserInfo(java.lang.Object getUserInfo) throws java.rmi.RemoteException, com.bigmachines.soap.Fault{
    if (securityServicePortType == null)
      _initSecurityServicePortTypeProxy();
    return securityServicePortType.getUserInfo(getUserInfo);
  }
  
  public com.bigmachines.soap.LoginResponse login(com.bigmachines.soap.Login login) throws java.rmi.RemoteException, com.bigmachines.soap.Fault{
    if (securityServicePortType == null)
      _initSecurityServicePortTypeProxy();
    return securityServicePortType.login(login);
  }
  
  public com.bigmachines.soap.LogoutResponse logout(java.lang.Object logout) throws java.rmi.RemoteException, com.bigmachines.soap.Fault{
    if (securityServicePortType == null)
      _initSecurityServicePortTypeProxy();
    return securityServicePortType.logout(logout);
  }
  
  public com.bigmachines.soap.SetSessionCurrencyResponse setSessionCurrency(com.bigmachines.soap.SetSessionCurrency setSessionCurrency) throws java.rmi.RemoteException, com.bigmachines.soap.Fault{
    if (securityServicePortType == null)
      _initSecurityServicePortTypeProxy();
    return securityServicePortType.setSessionCurrency(setSessionCurrency);
  }
  
  
}