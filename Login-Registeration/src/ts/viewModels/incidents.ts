/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import "oj-c/input-text";
import "oj-c/input-number";
import "oj-c/button";
class IncidentsViewModel {
  username: ko.Observable<string>;
  password: ko.Observable<string>;
  firstname:ko.Observable<string>;
  lastname:ko.Observable<string>;
   dateofbirth:ko.Observable<string>;
   emailid:ko.Observable<string>;
   phonenumber:ko.Observable<string>;
   address:ko.Observable<string>;
  button2Text: string;
clickedButton: ko.Observable<string>;

  value: ko.Observable<string>;
  rawValue: ko.Observable<string>;
  constructor() {
    this.firstname = ko.observable("");
    this.lastname = ko.observable("");
    this.username = ko.observable("");
    this.password = ko.observable("");
    this.dateofbirth=ko.observable("");
    this.emailid=ko.observable("");
    this.phonenumber=ko.observable("");
    this.address=ko.observable("");
    this.value = ko.observable("");
    this.rawValue = ko.observable("");
    this.button2Text = "Button 2";
    this.clickedButton = ko.observable("(None clicked yet)");
  }
  
  public buttonAction = async (event: Event) => {
    console.log("Clicked");
    console.log(this.firstname());
    console.log(this.lastname());
    console.log(this.username());
    console.log(this.password());
    console.log(this.dateofbirth());
    console.log(this.emailid());
    console.log(this.phonenumber());
    console.log(this.address());
    const row1 = {
      first_name: this.firstname(),
      last_name: this.lastname(),
      approval_status: "No",
      username: this.username(),
      password: this.password(),
      login_attempts:"0",
      date_of_birth:this.dateofbirth(),
      email_id:this.emailid(),
      phone_number:this.phonenumber(),
      address:this.address(),
  };
  const request = new Request("http://localhost:9090/customercrudapi/register", {
    headers: new Headers({
      "Content-type": "application/json; charset=UTF-8",
    }),
    body: JSON.stringify(row1),
    method: "POST",
  });
  const response = await fetch(request);
  const result = await response.json();

  alert("registeration Status is " + result)
  }
 
}

export = IncidentsViewModel;
