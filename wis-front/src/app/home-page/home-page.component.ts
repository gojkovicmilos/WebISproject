import { Component, OnInit, OnDestroy } from '@angular/core';
import Center from '../centers/Center';
import { CenterService } from '../centers/center.service';
import { Router, ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';
import { DomSanitizer } from '@angular/platform-browser';
import Country from '../Country';
import { CountryService } from '../country-service';
import { PlaceService } from '../place-service';
import { Place } from '../place';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  centers: Center[];
  country: Country[];
  place: Place[];

  countries: any = {};
  places:any = {}
  constructor(private route: ActivatedRoute, private dataService: DataService, private router: Router, private sanitizer: DomSanitizer, private cnt: CenterService, private cos: CountryService, private ps: PlaceService) {

  }

  ngOnInit() {
    this.cnt.getCenter()
      .subscribe((data: Center[]) => {
        this.centers = data;

      });
    this.route.params.subscribe(params => {
      this.cos.getCountryById(params.id).subscribe(res => {
        this.countries = res;
      });
    });
    this.route.params.subscribe(params => {
      this.ps.getPlaceById(params.id).subscribe(res => {
        this.places = res;
      });
    });

    if (localStorage.getItem("username") === null)
      localStorage.setItem("username", "Guest");

    console.log(localStorage.getItem("username"));

    this.cos
      .getCountries()
      .subscribe((data: Country[]) => {
        this.country = data;
      });
    this.ps
      .getPlaces()
      .subscribe((data: Place[]) => {
        this.place = data;
      });
  }

  punjenje(id): void {
    this.dataService.idCenter = id;
    localStorage.setItem("idCentra", this.dataService.idCenter.toString());
  }

  transform(img: Int8Array, mimetype: string) {
    return this.sanitizer.bypassSecurityTrustResourceUrl("data:" + mimetype + ";base64, " + img.toString());
  }

  ngOnDestroy() {

  }


}
