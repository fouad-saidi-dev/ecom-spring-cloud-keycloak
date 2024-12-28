import {Component, OnInit} from '@angular/core';
import {KeycloakService} from "keycloak-angular";
import {KeycloakProfile} from "keycloak-js";

@Component({
  selector: 'app-app-bar',
  templateUrl: './app-bar.component.html',
  styleUrl: './app-bar.component.css'
})
export class AppBarComponent implements OnInit{
  public profile!:KeycloakProfile;

  constructor(public keycloakService: KeycloakService) {
  }
  ngOnInit(): void {
    if(this.keycloakService.isLoggedIn()){
      this.keycloakService.loadUserProfile().then((profile) => {
        this.profile = profile;
      });
    }
  }
  async handleLogin() {
    await this.keycloakService.login({
      redirectUri: window.location.origin + '/products'
    });
  }
  handleLogout() {
    this.keycloakService.logout(window.location.origin);
  }


}
