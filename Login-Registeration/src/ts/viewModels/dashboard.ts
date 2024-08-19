/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import Message = require("ojs/ojmessaging");
import * as ko from "knockout";
import "oj-c/input-text";
import 'oj-c/input-password';
import "oj-c/button";
class DashboardViewModel {
  username: ko.Observable<string>;
  password: ko.Observable<string>;
  button2Text: string;
  clickedButton: ko.Observable<string>;

  constructor() {
    this.username = ko.observable("");
    this.password = ko.observable("");
    this.button2Text = "Button 2";
    this.clickedButton = ko.observable("(None clicked yet)");
    
  }

  public buttonAction = async (event: Event) => {
    console.log("Clicked");
    

    const row1 = {
      "username": this.username(),
      "passwrd": this.password()
  };


    const request = new Request("http://localhost:9090/customercrudapi/login", {
      headers: new Headers({
        "Content-type": "application/json; charset=UTF-8",
      }),
      body: JSON.stringify(row1),
      method: "POST",
    });


    const response = await fetch(request);
    const result = await response.json();

    alert("Login Status is " + result)
  }

}
export = DashboardViewModel;
