import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsBoutiqueComponent } from './details-boutique.component';

describe('DetailsBoutiqueComponent', () => {
  let component: DetailsBoutiqueComponent;
  let fixture: ComponentFixture<DetailsBoutiqueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsBoutiqueComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsBoutiqueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
