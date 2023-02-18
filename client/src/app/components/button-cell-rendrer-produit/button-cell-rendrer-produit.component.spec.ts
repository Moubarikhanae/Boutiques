import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ButtonCellRendrerProduitComponent } from './button-cell-rendrer-produit.component';

describe('ButtonCellRendrerProduitComponent', () => {
  let component: ButtonCellRendrerProduitComponent;
  let fixture: ComponentFixture<ButtonCellRendrerProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ButtonCellRendrerProduitComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ButtonCellRendrerProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
