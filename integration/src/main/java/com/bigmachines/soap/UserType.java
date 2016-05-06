/**
 * UserType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bigmachines.soap;

public class UserType  implements java.io.Serializable {
    private java.lang.String session_currency;

    private com.bigmachines.soap.BooleanOrBlank send_password_email;

    private java.lang.String company_name;

    private java.lang.String login;

    private java.lang.String password;

    private java.lang.String type;

    private java.lang.String first_name;

    private java.lang.String last_name;

    private java.lang.String job_title;

    private java.lang.String email;

    private java.lang.String phone;

    private java.lang.String fax;

    private java.lang.String bill_address_1;

    private java.lang.String bill_address_2;

    private java.lang.String bill_city;

    private java.lang.String bill_state_province;

    private java.lang.String bill_zip;

    private java.lang.String bill_country;

    private com.bigmachines.soap.BooleanOrBlank separate_ship_addr;

    private java.lang.String ship_address_1;

    private java.lang.String ship_address_2;

    private java.lang.String ship_city;

    private java.lang.String ship_state_province;

    private java.lang.String ship_zip;

    private java.lang.String ship_country;

    private com.bigmachines.soap.NotificationPreferenceType notification_pref;

    private java.lang.String bm_language;

    private java.lang.String currency_preference;

    private java.lang.String bill_first_name;

    private java.lang.String bill_last_name;

    private java.lang.String bill_company;

    private java.lang.String bill_company_2;

    private java.lang.String bill_phone;

    private java.lang.String bill_fax;

    private java.lang.String bill_email;

    private java.lang.String ship_first_name;

    private java.lang.String ship_last_name;

    private java.lang.String ship_company;

    private java.lang.String ship_company_2;

    private java.lang.String ship_phone;

    private java.lang.String ship_fax;

    private java.lang.String ship_email;

    private java.lang.String bm_units;

    private java.lang.String date_format;

    private java.lang.String time_zone;

    private java.lang.String number_format;

    private java.lang.String partner_login;

    private java.lang.String partner_password;

    private java.lang.String status;

    private java.lang.Boolean super_user_access_perm;

    private java.lang.Integer enabled_for_sso;

    private java.lang.String external_sso_id;

    private java.lang.String approval_delegate;

    private java.lang.Integer mobile_enabled;

    private java.lang.Integer web_services_only;

    private com.bigmachines.soap.UserTypeGroup_listGroup[] group_list;

    public UserType() {
    }

    public UserType(
           java.lang.String session_currency,
           com.bigmachines.soap.BooleanOrBlank send_password_email,
           java.lang.String company_name,
           java.lang.String login,
           java.lang.String password,
           java.lang.String type,
           java.lang.String first_name,
           java.lang.String last_name,
           java.lang.String job_title,
           java.lang.String email,
           java.lang.String phone,
           java.lang.String fax,
           java.lang.String bill_address_1,
           java.lang.String bill_address_2,
           java.lang.String bill_city,
           java.lang.String bill_state_province,
           java.lang.String bill_zip,
           java.lang.String bill_country,
           com.bigmachines.soap.BooleanOrBlank separate_ship_addr,
           java.lang.String ship_address_1,
           java.lang.String ship_address_2,
           java.lang.String ship_city,
           java.lang.String ship_state_province,
           java.lang.String ship_zip,
           java.lang.String ship_country,
           com.bigmachines.soap.NotificationPreferenceType notification_pref,
           java.lang.String bm_language,
           java.lang.String currency_preference,
           java.lang.String bill_first_name,
           java.lang.String bill_last_name,
           java.lang.String bill_company,
           java.lang.String bill_company_2,
           java.lang.String bill_phone,
           java.lang.String bill_fax,
           java.lang.String bill_email,
           java.lang.String ship_first_name,
           java.lang.String ship_last_name,
           java.lang.String ship_company,
           java.lang.String ship_company_2,
           java.lang.String ship_phone,
           java.lang.String ship_fax,
           java.lang.String ship_email,
           java.lang.String bm_units,
           java.lang.String date_format,
           java.lang.String time_zone,
           java.lang.String number_format,
           java.lang.String partner_login,
           java.lang.String partner_password,
           java.lang.String status,
           java.lang.Boolean super_user_access_perm,
           java.lang.Integer enabled_for_sso,
           java.lang.String external_sso_id,
           java.lang.String approval_delegate,
           java.lang.Integer mobile_enabled,
           java.lang.Integer web_services_only,
           com.bigmachines.soap.UserTypeGroup_listGroup[] group_list) {
           this.session_currency = session_currency;
           this.send_password_email = send_password_email;
           this.company_name = company_name;
           this.login = login;
           this.password = password;
           this.type = type;
           this.first_name = first_name;
           this.last_name = last_name;
           this.job_title = job_title;
           this.email = email;
           this.phone = phone;
           this.fax = fax;
           this.bill_address_1 = bill_address_1;
           this.bill_address_2 = bill_address_2;
           this.bill_city = bill_city;
           this.bill_state_province = bill_state_province;
           this.bill_zip = bill_zip;
           this.bill_country = bill_country;
           this.separate_ship_addr = separate_ship_addr;
           this.ship_address_1 = ship_address_1;
           this.ship_address_2 = ship_address_2;
           this.ship_city = ship_city;
           this.ship_state_province = ship_state_province;
           this.ship_zip = ship_zip;
           this.ship_country = ship_country;
           this.notification_pref = notification_pref;
           this.bm_language = bm_language;
           this.currency_preference = currency_preference;
           this.bill_first_name = bill_first_name;
           this.bill_last_name = bill_last_name;
           this.bill_company = bill_company;
           this.bill_company_2 = bill_company_2;
           this.bill_phone = bill_phone;
           this.bill_fax = bill_fax;
           this.bill_email = bill_email;
           this.ship_first_name = ship_first_name;
           this.ship_last_name = ship_last_name;
           this.ship_company = ship_company;
           this.ship_company_2 = ship_company_2;
           this.ship_phone = ship_phone;
           this.ship_fax = ship_fax;
           this.ship_email = ship_email;
           this.bm_units = bm_units;
           this.date_format = date_format;
           this.time_zone = time_zone;
           this.number_format = number_format;
           this.partner_login = partner_login;
           this.partner_password = partner_password;
           this.status = status;
           this.super_user_access_perm = super_user_access_perm;
           this.enabled_for_sso = enabled_for_sso;
           this.external_sso_id = external_sso_id;
           this.approval_delegate = approval_delegate;
           this.mobile_enabled = mobile_enabled;
           this.web_services_only = web_services_only;
           this.group_list = group_list;
    }


    /**
     * Gets the session_currency value for this UserType.
     * 
     * @return session_currency
     */
    public java.lang.String getSession_currency() {
        return session_currency;
    }


    /**
     * Sets the session_currency value for this UserType.
     * 
     * @param session_currency
     */
    public void setSession_currency(java.lang.String session_currency) {
        this.session_currency = session_currency;
    }


    /**
     * Gets the send_password_email value for this UserType.
     * 
     * @return send_password_email
     */
    public com.bigmachines.soap.BooleanOrBlank getSend_password_email() {
        return send_password_email;
    }


    /**
     * Sets the send_password_email value for this UserType.
     * 
     * @param send_password_email
     */
    public void setSend_password_email(com.bigmachines.soap.BooleanOrBlank send_password_email) {
        this.send_password_email = send_password_email;
    }


    /**
     * Gets the company_name value for this UserType.
     * 
     * @return company_name
     */
    public java.lang.String getCompany_name() {
        return company_name;
    }


    /**
     * Sets the company_name value for this UserType.
     * 
     * @param company_name
     */
    public void setCompany_name(java.lang.String company_name) {
        this.company_name = company_name;
    }


    /**
     * Gets the login value for this UserType.
     * 
     * @return login
     */
    public java.lang.String getLogin() {
        return login;
    }


    /**
     * Sets the login value for this UserType.
     * 
     * @param login
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }


    /**
     * Gets the password value for this UserType.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this UserType.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the type value for this UserType.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this UserType.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the first_name value for this UserType.
     * 
     * @return first_name
     */
    public java.lang.String getFirst_name() {
        return first_name;
    }


    /**
     * Sets the first_name value for this UserType.
     * 
     * @param first_name
     */
    public void setFirst_name(java.lang.String first_name) {
        this.first_name = first_name;
    }


    /**
     * Gets the last_name value for this UserType.
     * 
     * @return last_name
     */
    public java.lang.String getLast_name() {
        return last_name;
    }


    /**
     * Sets the last_name value for this UserType.
     * 
     * @param last_name
     */
    public void setLast_name(java.lang.String last_name) {
        this.last_name = last_name;
    }


    /**
     * Gets the job_title value for this UserType.
     * 
     * @return job_title
     */
    public java.lang.String getJob_title() {
        return job_title;
    }


    /**
     * Sets the job_title value for this UserType.
     * 
     * @param job_title
     */
    public void setJob_title(java.lang.String job_title) {
        this.job_title = job_title;
    }


    /**
     * Gets the email value for this UserType.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this UserType.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the phone value for this UserType.
     * 
     * @return phone
     */
    public java.lang.String getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this UserType.
     * 
     * @param phone
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }


    /**
     * Gets the fax value for this UserType.
     * 
     * @return fax
     */
    public java.lang.String getFax() {
        return fax;
    }


    /**
     * Sets the fax value for this UserType.
     * 
     * @param fax
     */
    public void setFax(java.lang.String fax) {
        this.fax = fax;
    }


    /**
     * Gets the bill_address_1 value for this UserType.
     * 
     * @return bill_address_1
     */
    public java.lang.String getBill_address_1() {
        return bill_address_1;
    }


    /**
     * Sets the bill_address_1 value for this UserType.
     * 
     * @param bill_address_1
     */
    public void setBill_address_1(java.lang.String bill_address_1) {
        this.bill_address_1 = bill_address_1;
    }


    /**
     * Gets the bill_address_2 value for this UserType.
     * 
     * @return bill_address_2
     */
    public java.lang.String getBill_address_2() {
        return bill_address_2;
    }


    /**
     * Sets the bill_address_2 value for this UserType.
     * 
     * @param bill_address_2
     */
    public void setBill_address_2(java.lang.String bill_address_2) {
        this.bill_address_2 = bill_address_2;
    }


    /**
     * Gets the bill_city value for this UserType.
     * 
     * @return bill_city
     */
    public java.lang.String getBill_city() {
        return bill_city;
    }


    /**
     * Sets the bill_city value for this UserType.
     * 
     * @param bill_city
     */
    public void setBill_city(java.lang.String bill_city) {
        this.bill_city = bill_city;
    }


    /**
     * Gets the bill_state_province value for this UserType.
     * 
     * @return bill_state_province
     */
    public java.lang.String getBill_state_province() {
        return bill_state_province;
    }


    /**
     * Sets the bill_state_province value for this UserType.
     * 
     * @param bill_state_province
     */
    public void setBill_state_province(java.lang.String bill_state_province) {
        this.bill_state_province = bill_state_province;
    }


    /**
     * Gets the bill_zip value for this UserType.
     * 
     * @return bill_zip
     */
    public java.lang.String getBill_zip() {
        return bill_zip;
    }


    /**
     * Sets the bill_zip value for this UserType.
     * 
     * @param bill_zip
     */
    public void setBill_zip(java.lang.String bill_zip) {
        this.bill_zip = bill_zip;
    }


    /**
     * Gets the bill_country value for this UserType.
     * 
     * @return bill_country
     */
    public java.lang.String getBill_country() {
        return bill_country;
    }


    /**
     * Sets the bill_country value for this UserType.
     * 
     * @param bill_country
     */
    public void setBill_country(java.lang.String bill_country) {
        this.bill_country = bill_country;
    }


    /**
     * Gets the separate_ship_addr value for this UserType.
     * 
     * @return separate_ship_addr
     */
    public com.bigmachines.soap.BooleanOrBlank getSeparate_ship_addr() {
        return separate_ship_addr;
    }


    /**
     * Sets the separate_ship_addr value for this UserType.
     * 
     * @param separate_ship_addr
     */
    public void setSeparate_ship_addr(com.bigmachines.soap.BooleanOrBlank separate_ship_addr) {
        this.separate_ship_addr = separate_ship_addr;
    }


    /**
     * Gets the ship_address_1 value for this UserType.
     * 
     * @return ship_address_1
     */
    public java.lang.String getShip_address_1() {
        return ship_address_1;
    }


    /**
     * Sets the ship_address_1 value for this UserType.
     * 
     * @param ship_address_1
     */
    public void setShip_address_1(java.lang.String ship_address_1) {
        this.ship_address_1 = ship_address_1;
    }


    /**
     * Gets the ship_address_2 value for this UserType.
     * 
     * @return ship_address_2
     */
    public java.lang.String getShip_address_2() {
        return ship_address_2;
    }


    /**
     * Sets the ship_address_2 value for this UserType.
     * 
     * @param ship_address_2
     */
    public void setShip_address_2(java.lang.String ship_address_2) {
        this.ship_address_2 = ship_address_2;
    }


    /**
     * Gets the ship_city value for this UserType.
     * 
     * @return ship_city
     */
    public java.lang.String getShip_city() {
        return ship_city;
    }


    /**
     * Sets the ship_city value for this UserType.
     * 
     * @param ship_city
     */
    public void setShip_city(java.lang.String ship_city) {
        this.ship_city = ship_city;
    }


    /**
     * Gets the ship_state_province value for this UserType.
     * 
     * @return ship_state_province
     */
    public java.lang.String getShip_state_province() {
        return ship_state_province;
    }


    /**
     * Sets the ship_state_province value for this UserType.
     * 
     * @param ship_state_province
     */
    public void setShip_state_province(java.lang.String ship_state_province) {
        this.ship_state_province = ship_state_province;
    }


    /**
     * Gets the ship_zip value for this UserType.
     * 
     * @return ship_zip
     */
    public java.lang.String getShip_zip() {
        return ship_zip;
    }


    /**
     * Sets the ship_zip value for this UserType.
     * 
     * @param ship_zip
     */
    public void setShip_zip(java.lang.String ship_zip) {
        this.ship_zip = ship_zip;
    }


    /**
     * Gets the ship_country value for this UserType.
     * 
     * @return ship_country
     */
    public java.lang.String getShip_country() {
        return ship_country;
    }


    /**
     * Sets the ship_country value for this UserType.
     * 
     * @param ship_country
     */
    public void setShip_country(java.lang.String ship_country) {
        this.ship_country = ship_country;
    }


    /**
     * Gets the notification_pref value for this UserType.
     * 
     * @return notification_pref
     */
    public com.bigmachines.soap.NotificationPreferenceType getNotification_pref() {
        return notification_pref;
    }


    /**
     * Sets the notification_pref value for this UserType.
     * 
     * @param notification_pref
     */
    public void setNotification_pref(com.bigmachines.soap.NotificationPreferenceType notification_pref) {
        this.notification_pref = notification_pref;
    }


    /**
     * Gets the bm_language value for this UserType.
     * 
     * @return bm_language
     */
    public java.lang.String getBm_language() {
        return bm_language;
    }


    /**
     * Sets the bm_language value for this UserType.
     * 
     * @param bm_language
     */
    public void setBm_language(java.lang.String bm_language) {
        this.bm_language = bm_language;
    }


    /**
     * Gets the currency_preference value for this UserType.
     * 
     * @return currency_preference
     */
    public java.lang.String getCurrency_preference() {
        return currency_preference;
    }


    /**
     * Sets the currency_preference value for this UserType.
     * 
     * @param currency_preference
     */
    public void setCurrency_preference(java.lang.String currency_preference) {
        this.currency_preference = currency_preference;
    }


    /**
     * Gets the bill_first_name value for this UserType.
     * 
     * @return bill_first_name
     */
    public java.lang.String getBill_first_name() {
        return bill_first_name;
    }


    /**
     * Sets the bill_first_name value for this UserType.
     * 
     * @param bill_first_name
     */
    public void setBill_first_name(java.lang.String bill_first_name) {
        this.bill_first_name = bill_first_name;
    }


    /**
     * Gets the bill_last_name value for this UserType.
     * 
     * @return bill_last_name
     */
    public java.lang.String getBill_last_name() {
        return bill_last_name;
    }


    /**
     * Sets the bill_last_name value for this UserType.
     * 
     * @param bill_last_name
     */
    public void setBill_last_name(java.lang.String bill_last_name) {
        this.bill_last_name = bill_last_name;
    }


    /**
     * Gets the bill_company value for this UserType.
     * 
     * @return bill_company
     */
    public java.lang.String getBill_company() {
        return bill_company;
    }


    /**
     * Sets the bill_company value for this UserType.
     * 
     * @param bill_company
     */
    public void setBill_company(java.lang.String bill_company) {
        this.bill_company = bill_company;
    }


    /**
     * Gets the bill_company_2 value for this UserType.
     * 
     * @return bill_company_2
     */
    public java.lang.String getBill_company_2() {
        return bill_company_2;
    }


    /**
     * Sets the bill_company_2 value for this UserType.
     * 
     * @param bill_company_2
     */
    public void setBill_company_2(java.lang.String bill_company_2) {
        this.bill_company_2 = bill_company_2;
    }


    /**
     * Gets the bill_phone value for this UserType.
     * 
     * @return bill_phone
     */
    public java.lang.String getBill_phone() {
        return bill_phone;
    }


    /**
     * Sets the bill_phone value for this UserType.
     * 
     * @param bill_phone
     */
    public void setBill_phone(java.lang.String bill_phone) {
        this.bill_phone = bill_phone;
    }


    /**
     * Gets the bill_fax value for this UserType.
     * 
     * @return bill_fax
     */
    public java.lang.String getBill_fax() {
        return bill_fax;
    }


    /**
     * Sets the bill_fax value for this UserType.
     * 
     * @param bill_fax
     */
    public void setBill_fax(java.lang.String bill_fax) {
        this.bill_fax = bill_fax;
    }


    /**
     * Gets the bill_email value for this UserType.
     * 
     * @return bill_email
     */
    public java.lang.String getBill_email() {
        return bill_email;
    }


    /**
     * Sets the bill_email value for this UserType.
     * 
     * @param bill_email
     */
    public void setBill_email(java.lang.String bill_email) {
        this.bill_email = bill_email;
    }


    /**
     * Gets the ship_first_name value for this UserType.
     * 
     * @return ship_first_name
     */
    public java.lang.String getShip_first_name() {
        return ship_first_name;
    }


    /**
     * Sets the ship_first_name value for this UserType.
     * 
     * @param ship_first_name
     */
    public void setShip_first_name(java.lang.String ship_first_name) {
        this.ship_first_name = ship_first_name;
    }


    /**
     * Gets the ship_last_name value for this UserType.
     * 
     * @return ship_last_name
     */
    public java.lang.String getShip_last_name() {
        return ship_last_name;
    }


    /**
     * Sets the ship_last_name value for this UserType.
     * 
     * @param ship_last_name
     */
    public void setShip_last_name(java.lang.String ship_last_name) {
        this.ship_last_name = ship_last_name;
    }


    /**
     * Gets the ship_company value for this UserType.
     * 
     * @return ship_company
     */
    public java.lang.String getShip_company() {
        return ship_company;
    }


    /**
     * Sets the ship_company value for this UserType.
     * 
     * @param ship_company
     */
    public void setShip_company(java.lang.String ship_company) {
        this.ship_company = ship_company;
    }


    /**
     * Gets the ship_company_2 value for this UserType.
     * 
     * @return ship_company_2
     */
    public java.lang.String getShip_company_2() {
        return ship_company_2;
    }


    /**
     * Sets the ship_company_2 value for this UserType.
     * 
     * @param ship_company_2
     */
    public void setShip_company_2(java.lang.String ship_company_2) {
        this.ship_company_2 = ship_company_2;
    }


    /**
     * Gets the ship_phone value for this UserType.
     * 
     * @return ship_phone
     */
    public java.lang.String getShip_phone() {
        return ship_phone;
    }


    /**
     * Sets the ship_phone value for this UserType.
     * 
     * @param ship_phone
     */
    public void setShip_phone(java.lang.String ship_phone) {
        this.ship_phone = ship_phone;
    }


    /**
     * Gets the ship_fax value for this UserType.
     * 
     * @return ship_fax
     */
    public java.lang.String getShip_fax() {
        return ship_fax;
    }


    /**
     * Sets the ship_fax value for this UserType.
     * 
     * @param ship_fax
     */
    public void setShip_fax(java.lang.String ship_fax) {
        this.ship_fax = ship_fax;
    }


    /**
     * Gets the ship_email value for this UserType.
     * 
     * @return ship_email
     */
    public java.lang.String getShip_email() {
        return ship_email;
    }


    /**
     * Sets the ship_email value for this UserType.
     * 
     * @param ship_email
     */
    public void setShip_email(java.lang.String ship_email) {
        this.ship_email = ship_email;
    }


    /**
     * Gets the bm_units value for this UserType.
     * 
     * @return bm_units
     */
    public java.lang.String getBm_units() {
        return bm_units;
    }


    /**
     * Sets the bm_units value for this UserType.
     * 
     * @param bm_units
     */
    public void setBm_units(java.lang.String bm_units) {
        this.bm_units = bm_units;
    }


    /**
     * Gets the date_format value for this UserType.
     * 
     * @return date_format
     */
    public java.lang.String getDate_format() {
        return date_format;
    }


    /**
     * Sets the date_format value for this UserType.
     * 
     * @param date_format
     */
    public void setDate_format(java.lang.String date_format) {
        this.date_format = date_format;
    }


    /**
     * Gets the time_zone value for this UserType.
     * 
     * @return time_zone
     */
    public java.lang.String getTime_zone() {
        return time_zone;
    }


    /**
     * Sets the time_zone value for this UserType.
     * 
     * @param time_zone
     */
    public void setTime_zone(java.lang.String time_zone) {
        this.time_zone = time_zone;
    }


    /**
     * Gets the number_format value for this UserType.
     * 
     * @return number_format
     */
    public java.lang.String getNumber_format() {
        return number_format;
    }


    /**
     * Sets the number_format value for this UserType.
     * 
     * @param number_format
     */
    public void setNumber_format(java.lang.String number_format) {
        this.number_format = number_format;
    }


    /**
     * Gets the partner_login value for this UserType.
     * 
     * @return partner_login
     */
    public java.lang.String getPartner_login() {
        return partner_login;
    }


    /**
     * Sets the partner_login value for this UserType.
     * 
     * @param partner_login
     */
    public void setPartner_login(java.lang.String partner_login) {
        this.partner_login = partner_login;
    }


    /**
     * Gets the partner_password value for this UserType.
     * 
     * @return partner_password
     */
    public java.lang.String getPartner_password() {
        return partner_password;
    }


    /**
     * Sets the partner_password value for this UserType.
     * 
     * @param partner_password
     */
    public void setPartner_password(java.lang.String partner_password) {
        this.partner_password = partner_password;
    }


    /**
     * Gets the status value for this UserType.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this UserType.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the super_user_access_perm value for this UserType.
     * 
     * @return super_user_access_perm
     */
    public java.lang.Boolean getSuper_user_access_perm() {
        return super_user_access_perm;
    }


    /**
     * Sets the super_user_access_perm value for this UserType.
     * 
     * @param super_user_access_perm
     */
    public void setSuper_user_access_perm(java.lang.Boolean super_user_access_perm) {
        this.super_user_access_perm = super_user_access_perm;
    }


    /**
     * Gets the enabled_for_sso value for this UserType.
     * 
     * @return enabled_for_sso
     */
    public java.lang.Integer getEnabled_for_sso() {
        return enabled_for_sso;
    }


    /**
     * Sets the enabled_for_sso value for this UserType.
     * 
     * @param enabled_for_sso
     */
    public void setEnabled_for_sso(java.lang.Integer enabled_for_sso) {
        this.enabled_for_sso = enabled_for_sso;
    }


    /**
     * Gets the external_sso_id value for this UserType.
     * 
     * @return external_sso_id
     */
    public java.lang.String getExternal_sso_id() {
        return external_sso_id;
    }


    /**
     * Sets the external_sso_id value for this UserType.
     * 
     * @param external_sso_id
     */
    public void setExternal_sso_id(java.lang.String external_sso_id) {
        this.external_sso_id = external_sso_id;
    }


    /**
     * Gets the approval_delegate value for this UserType.
     * 
     * @return approval_delegate
     */
    public java.lang.String getApproval_delegate() {
        return approval_delegate;
    }


    /**
     * Sets the approval_delegate value for this UserType.
     * 
     * @param approval_delegate
     */
    public void setApproval_delegate(java.lang.String approval_delegate) {
        this.approval_delegate = approval_delegate;
    }


    /**
     * Gets the mobile_enabled value for this UserType.
     * 
     * @return mobile_enabled
     */
    public java.lang.Integer getMobile_enabled() {
        return mobile_enabled;
    }


    /**
     * Sets the mobile_enabled value for this UserType.
     * 
     * @param mobile_enabled
     */
    public void setMobile_enabled(java.lang.Integer mobile_enabled) {
        this.mobile_enabled = mobile_enabled;
    }


    /**
     * Gets the web_services_only value for this UserType.
     * 
     * @return web_services_only
     */
    public java.lang.Integer getWeb_services_only() {
        return web_services_only;
    }


    /**
     * Sets the web_services_only value for this UserType.
     * 
     * @param web_services_only
     */
    public void setWeb_services_only(java.lang.Integer web_services_only) {
        this.web_services_only = web_services_only;
    }


    /**
     * Gets the group_list value for this UserType.
     * 
     * @return group_list
     */
    public com.bigmachines.soap.UserTypeGroup_listGroup[] getGroup_list() {
        return group_list;
    }


    /**
     * Sets the group_list value for this UserType.
     * 
     * @param group_list
     */
    public void setGroup_list(com.bigmachines.soap.UserTypeGroup_listGroup[] group_list) {
        this.group_list = group_list;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserType)) return false;
        UserType other = (UserType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.session_currency==null && other.getSession_currency()==null) || 
             (this.session_currency!=null &&
              this.session_currency.equals(other.getSession_currency()))) &&
            ((this.send_password_email==null && other.getSend_password_email()==null) || 
             (this.send_password_email!=null &&
              this.send_password_email.equals(other.getSend_password_email()))) &&
            ((this.company_name==null && other.getCompany_name()==null) || 
             (this.company_name!=null &&
              this.company_name.equals(other.getCompany_name()))) &&
            ((this.login==null && other.getLogin()==null) || 
             (this.login!=null &&
              this.login.equals(other.getLogin()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.first_name==null && other.getFirst_name()==null) || 
             (this.first_name!=null &&
              this.first_name.equals(other.getFirst_name()))) &&
            ((this.last_name==null && other.getLast_name()==null) || 
             (this.last_name!=null &&
              this.last_name.equals(other.getLast_name()))) &&
            ((this.job_title==null && other.getJob_title()==null) || 
             (this.job_title!=null &&
              this.job_title.equals(other.getJob_title()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              this.phone.equals(other.getPhone()))) &&
            ((this.fax==null && other.getFax()==null) || 
             (this.fax!=null &&
              this.fax.equals(other.getFax()))) &&
            ((this.bill_address_1==null && other.getBill_address_1()==null) || 
             (this.bill_address_1!=null &&
              this.bill_address_1.equals(other.getBill_address_1()))) &&
            ((this.bill_address_2==null && other.getBill_address_2()==null) || 
             (this.bill_address_2!=null &&
              this.bill_address_2.equals(other.getBill_address_2()))) &&
            ((this.bill_city==null && other.getBill_city()==null) || 
             (this.bill_city!=null &&
              this.bill_city.equals(other.getBill_city()))) &&
            ((this.bill_state_province==null && other.getBill_state_province()==null) || 
             (this.bill_state_province!=null &&
              this.bill_state_province.equals(other.getBill_state_province()))) &&
            ((this.bill_zip==null && other.getBill_zip()==null) || 
             (this.bill_zip!=null &&
              this.bill_zip.equals(other.getBill_zip()))) &&
            ((this.bill_country==null && other.getBill_country()==null) || 
             (this.bill_country!=null &&
              this.bill_country.equals(other.getBill_country()))) &&
            ((this.separate_ship_addr==null && other.getSeparate_ship_addr()==null) || 
             (this.separate_ship_addr!=null &&
              this.separate_ship_addr.equals(other.getSeparate_ship_addr()))) &&
            ((this.ship_address_1==null && other.getShip_address_1()==null) || 
             (this.ship_address_1!=null &&
              this.ship_address_1.equals(other.getShip_address_1()))) &&
            ((this.ship_address_2==null && other.getShip_address_2()==null) || 
             (this.ship_address_2!=null &&
              this.ship_address_2.equals(other.getShip_address_2()))) &&
            ((this.ship_city==null && other.getShip_city()==null) || 
             (this.ship_city!=null &&
              this.ship_city.equals(other.getShip_city()))) &&
            ((this.ship_state_province==null && other.getShip_state_province()==null) || 
             (this.ship_state_province!=null &&
              this.ship_state_province.equals(other.getShip_state_province()))) &&
            ((this.ship_zip==null && other.getShip_zip()==null) || 
             (this.ship_zip!=null &&
              this.ship_zip.equals(other.getShip_zip()))) &&
            ((this.ship_country==null && other.getShip_country()==null) || 
             (this.ship_country!=null &&
              this.ship_country.equals(other.getShip_country()))) &&
            ((this.notification_pref==null && other.getNotification_pref()==null) || 
             (this.notification_pref!=null &&
              this.notification_pref.equals(other.getNotification_pref()))) &&
            ((this.bm_language==null && other.getBm_language()==null) || 
             (this.bm_language!=null &&
              this.bm_language.equals(other.getBm_language()))) &&
            ((this.currency_preference==null && other.getCurrency_preference()==null) || 
             (this.currency_preference!=null &&
              this.currency_preference.equals(other.getCurrency_preference()))) &&
            ((this.bill_first_name==null && other.getBill_first_name()==null) || 
             (this.bill_first_name!=null &&
              this.bill_first_name.equals(other.getBill_first_name()))) &&
            ((this.bill_last_name==null && other.getBill_last_name()==null) || 
             (this.bill_last_name!=null &&
              this.bill_last_name.equals(other.getBill_last_name()))) &&
            ((this.bill_company==null && other.getBill_company()==null) || 
             (this.bill_company!=null &&
              this.bill_company.equals(other.getBill_company()))) &&
            ((this.bill_company_2==null && other.getBill_company_2()==null) || 
             (this.bill_company_2!=null &&
              this.bill_company_2.equals(other.getBill_company_2()))) &&
            ((this.bill_phone==null && other.getBill_phone()==null) || 
             (this.bill_phone!=null &&
              this.bill_phone.equals(other.getBill_phone()))) &&
            ((this.bill_fax==null && other.getBill_fax()==null) || 
             (this.bill_fax!=null &&
              this.bill_fax.equals(other.getBill_fax()))) &&
            ((this.bill_email==null && other.getBill_email()==null) || 
             (this.bill_email!=null &&
              this.bill_email.equals(other.getBill_email()))) &&
            ((this.ship_first_name==null && other.getShip_first_name()==null) || 
             (this.ship_first_name!=null &&
              this.ship_first_name.equals(other.getShip_first_name()))) &&
            ((this.ship_last_name==null && other.getShip_last_name()==null) || 
             (this.ship_last_name!=null &&
              this.ship_last_name.equals(other.getShip_last_name()))) &&
            ((this.ship_company==null && other.getShip_company()==null) || 
             (this.ship_company!=null &&
              this.ship_company.equals(other.getShip_company()))) &&
            ((this.ship_company_2==null && other.getShip_company_2()==null) || 
             (this.ship_company_2!=null &&
              this.ship_company_2.equals(other.getShip_company_2()))) &&
            ((this.ship_phone==null && other.getShip_phone()==null) || 
             (this.ship_phone!=null &&
              this.ship_phone.equals(other.getShip_phone()))) &&
            ((this.ship_fax==null && other.getShip_fax()==null) || 
             (this.ship_fax!=null &&
              this.ship_fax.equals(other.getShip_fax()))) &&
            ((this.ship_email==null && other.getShip_email()==null) || 
             (this.ship_email!=null &&
              this.ship_email.equals(other.getShip_email()))) &&
            ((this.bm_units==null && other.getBm_units()==null) || 
             (this.bm_units!=null &&
              this.bm_units.equals(other.getBm_units()))) &&
            ((this.date_format==null && other.getDate_format()==null) || 
             (this.date_format!=null &&
              this.date_format.equals(other.getDate_format()))) &&
            ((this.time_zone==null && other.getTime_zone()==null) || 
             (this.time_zone!=null &&
              this.time_zone.equals(other.getTime_zone()))) &&
            ((this.number_format==null && other.getNumber_format()==null) || 
             (this.number_format!=null &&
              this.number_format.equals(other.getNumber_format()))) &&
            ((this.partner_login==null && other.getPartner_login()==null) || 
             (this.partner_login!=null &&
              this.partner_login.equals(other.getPartner_login()))) &&
            ((this.partner_password==null && other.getPartner_password()==null) || 
             (this.partner_password!=null &&
              this.partner_password.equals(other.getPartner_password()))) &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.super_user_access_perm==null && other.getSuper_user_access_perm()==null) || 
             (this.super_user_access_perm!=null &&
              this.super_user_access_perm.equals(other.getSuper_user_access_perm()))) &&
            ((this.enabled_for_sso==null && other.getEnabled_for_sso()==null) || 
             (this.enabled_for_sso!=null &&
              this.enabled_for_sso.equals(other.getEnabled_for_sso()))) &&
            ((this.external_sso_id==null && other.getExternal_sso_id()==null) || 
             (this.external_sso_id!=null &&
              this.external_sso_id.equals(other.getExternal_sso_id()))) &&
            ((this.approval_delegate==null && other.getApproval_delegate()==null) || 
             (this.approval_delegate!=null &&
              this.approval_delegate.equals(other.getApproval_delegate()))) &&
            ((this.mobile_enabled==null && other.getMobile_enabled()==null) || 
             (this.mobile_enabled!=null &&
              this.mobile_enabled.equals(other.getMobile_enabled()))) &&
            ((this.web_services_only==null && other.getWeb_services_only()==null) || 
             (this.web_services_only!=null &&
              this.web_services_only.equals(other.getWeb_services_only()))) &&
            ((this.group_list==null && other.getGroup_list()==null) || 
             (this.group_list!=null &&
              java.util.Arrays.equals(this.group_list, other.getGroup_list())));
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
        if (getSession_currency() != null) {
            _hashCode += getSession_currency().hashCode();
        }
        if (getSend_password_email() != null) {
            _hashCode += getSend_password_email().hashCode();
        }
        if (getCompany_name() != null) {
            _hashCode += getCompany_name().hashCode();
        }
        if (getLogin() != null) {
            _hashCode += getLogin().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getFirst_name() != null) {
            _hashCode += getFirst_name().hashCode();
        }
        if (getLast_name() != null) {
            _hashCode += getLast_name().hashCode();
        }
        if (getJob_title() != null) {
            _hashCode += getJob_title().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getPhone() != null) {
            _hashCode += getPhone().hashCode();
        }
        if (getFax() != null) {
            _hashCode += getFax().hashCode();
        }
        if (getBill_address_1() != null) {
            _hashCode += getBill_address_1().hashCode();
        }
        if (getBill_address_2() != null) {
            _hashCode += getBill_address_2().hashCode();
        }
        if (getBill_city() != null) {
            _hashCode += getBill_city().hashCode();
        }
        if (getBill_state_province() != null) {
            _hashCode += getBill_state_province().hashCode();
        }
        if (getBill_zip() != null) {
            _hashCode += getBill_zip().hashCode();
        }
        if (getBill_country() != null) {
            _hashCode += getBill_country().hashCode();
        }
        if (getSeparate_ship_addr() != null) {
            _hashCode += getSeparate_ship_addr().hashCode();
        }
        if (getShip_address_1() != null) {
            _hashCode += getShip_address_1().hashCode();
        }
        if (getShip_address_2() != null) {
            _hashCode += getShip_address_2().hashCode();
        }
        if (getShip_city() != null) {
            _hashCode += getShip_city().hashCode();
        }
        if (getShip_state_province() != null) {
            _hashCode += getShip_state_province().hashCode();
        }
        if (getShip_zip() != null) {
            _hashCode += getShip_zip().hashCode();
        }
        if (getShip_country() != null) {
            _hashCode += getShip_country().hashCode();
        }
        if (getNotification_pref() != null) {
            _hashCode += getNotification_pref().hashCode();
        }
        if (getBm_language() != null) {
            _hashCode += getBm_language().hashCode();
        }
        if (getCurrency_preference() != null) {
            _hashCode += getCurrency_preference().hashCode();
        }
        if (getBill_first_name() != null) {
            _hashCode += getBill_first_name().hashCode();
        }
        if (getBill_last_name() != null) {
            _hashCode += getBill_last_name().hashCode();
        }
        if (getBill_company() != null) {
            _hashCode += getBill_company().hashCode();
        }
        if (getBill_company_2() != null) {
            _hashCode += getBill_company_2().hashCode();
        }
        if (getBill_phone() != null) {
            _hashCode += getBill_phone().hashCode();
        }
        if (getBill_fax() != null) {
            _hashCode += getBill_fax().hashCode();
        }
        if (getBill_email() != null) {
            _hashCode += getBill_email().hashCode();
        }
        if (getShip_first_name() != null) {
            _hashCode += getShip_first_name().hashCode();
        }
        if (getShip_last_name() != null) {
            _hashCode += getShip_last_name().hashCode();
        }
        if (getShip_company() != null) {
            _hashCode += getShip_company().hashCode();
        }
        if (getShip_company_2() != null) {
            _hashCode += getShip_company_2().hashCode();
        }
        if (getShip_phone() != null) {
            _hashCode += getShip_phone().hashCode();
        }
        if (getShip_fax() != null) {
            _hashCode += getShip_fax().hashCode();
        }
        if (getShip_email() != null) {
            _hashCode += getShip_email().hashCode();
        }
        if (getBm_units() != null) {
            _hashCode += getBm_units().hashCode();
        }
        if (getDate_format() != null) {
            _hashCode += getDate_format().hashCode();
        }
        if (getTime_zone() != null) {
            _hashCode += getTime_zone().hashCode();
        }
        if (getNumber_format() != null) {
            _hashCode += getNumber_format().hashCode();
        }
        if (getPartner_login() != null) {
            _hashCode += getPartner_login().hashCode();
        }
        if (getPartner_password() != null) {
            _hashCode += getPartner_password().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getSuper_user_access_perm() != null) {
            _hashCode += getSuper_user_access_perm().hashCode();
        }
        if (getEnabled_for_sso() != null) {
            _hashCode += getEnabled_for_sso().hashCode();
        }
        if (getExternal_sso_id() != null) {
            _hashCode += getExternal_sso_id().hashCode();
        }
        if (getApproval_delegate() != null) {
            _hashCode += getApproval_delegate().hashCode();
        }
        if (getMobile_enabled() != null) {
            _hashCode += getMobile_enabled().hashCode();
        }
        if (getWeb_services_only() != null) {
            _hashCode += getWeb_services_only().hashCode();
        }
        if (getGroup_list() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGroup_list());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGroup_list(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "UserType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("session_currency");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "session_currency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("send_password_email");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "send_password_email"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "BooleanOrBlank"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("company_name");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "company_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("first_name");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "first_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("last_name");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "last_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("job_title");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "job_title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fax");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "fax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_address_1");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bill_address_1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_address_2");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bill_address_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_city");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bill_city"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_state_province");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bill_state_province"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_zip");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bill_zip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_country");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bill_country"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("separate_ship_addr");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "separate_ship_addr"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "BooleanOrBlank"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ship_address_1");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "ship_address_1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ship_address_2");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "ship_address_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ship_city");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "ship_city"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ship_state_province");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "ship_state_province"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ship_zip");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "ship_zip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ship_country");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "ship_country"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notification_pref");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "notification_pref"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "NotificationPreferenceType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bm_language");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bm_language"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currency_preference");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "currency_preference"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_first_name");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bill_first_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_last_name");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bill_last_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_company");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bill_company"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_company_2");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bill_company_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_phone");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bill_phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_fax");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bill_fax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bill_email");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bill_email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ship_first_name");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "ship_first_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ship_last_name");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "ship_last_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ship_company");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "ship_company"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ship_company_2");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "ship_company_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ship_phone");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "ship_phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ship_fax");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "ship_fax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ship_email");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "ship_email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bm_units");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "bm_units"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date_format");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "date_format"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("time_zone");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "time_zone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("number_format");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "number_format"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partner_login");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "partner_login"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partner_password");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "partner_password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("super_user_access_perm");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "super_user_access_perm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enabled_for_sso");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "enabled_for_sso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("external_sso_id");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "external_sso_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("approval_delegate");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "approval_delegate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile_enabled");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "mobile_enabled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("web_services_only");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "web_services_only"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("group_list");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "group_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:soap.bigmachines.com", ">>UserType>group_list>group"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("urn:soap.bigmachines.com", "group"));
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
