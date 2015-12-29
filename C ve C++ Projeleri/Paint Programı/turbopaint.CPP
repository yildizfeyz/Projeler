

#ifndef FARE_H
#define FARE_H
typedef int bool; //bool tipi tanimla
#define TRUE 1
#define FALSE 0

class fare {
enum { KESMENO = 0X33 }; //16lik sayi tabaninda fare kesme numarasi
enum { SOLTUS = 1, ORTATUS = 2, SAGTUS = 3 }; //fare tuslari
int ax, bx, cx, dx; //CPU yazmaclari
public:
fare();
fare(int, int, int, int);
void komut(int, int = 0, int = 0, int = 0);
void alan(int, int, int, int);
void durum(int);
void konumAl(int&, int&, bool&);
~fare();
};
#endif
/////////////
/////////////
#ifndef GRAFIK_H
#define GRAFIK_H
class grafik
{
char grYol[80+1];
public:
grafik();
grafik(const char *);
void giris();
void cikis();
~grafik();
};
#endif
/////////////
/////////////
#include <graphics.h>
#include <stdlib.h>
#include <string.h>
#include <iostream.h>
grafik::grafik()
{
strcpy(grYol, "c:\\tc\\bgi"); //varsayilan grafik dosyalarinin yolu
}
grafik::grafik(const char *grYol)
{
strcpy(this->grYol, grYol); //diger durumlarda yeni yol giriliyor
}
void grafik::giris()
{
int grHata = grOk;
int grKynk, grMod;
do //grafik ortamina gec ve yol bulunamamasi durumunda
//yeniden yol bilgisi alarak dene
{
grKynk = DETECT; grMod = 0;
initgraph(&grKynk, &grMod, grYol);//grafik ortamýna  giriþ yapar
if((grHata=graphresult()) != grOk) {
cout<<"BGI yolunu giriniz veya Cikis icin \'ESC\' tusuna tiklayiniz:";
cin>>grYol;
if(grYol[0] == 27) abort();
}
}while(grHata!=grOk);
settextjustify(BOTTOM_TEXT,LEFT_TEXT);//ekrana metin yaz
//outtextxy(100, getmaxy(), "Grafik modundan cikmak icin bir tusa basiniz");
}
void grafik::cikis()
{
closegraph(); //grafik ortamindan cik
}
grafik::~grafik()
{
cikis();
}
#include <dos.h>
//#include "fare.h"
fare::fare() : ax(0), bx(0), cx(0), dx(0) {}
fare::fare(int ax, int bx, int cx, int dx)
{
this->ax = ax;
this->bx = bx;
this->cx = cx;
this->dx = dx;
}
void fare::komut(int ax, int bx, int cx, int dx)
{
REGS girdi, cikti;
girdi.x.ax = ax;
girdi.x.bx = bx;
girdi.x.cx = cx;
girdi.x.dx = dx;
int86(KESMENO, &girdi, &cikti); //fare kesme fonk. cagir
this->ax = cikti.x.ax;
this->bx = cikti.x.bx;
this->cx = cikti.x.cx;
this->dx = cikti.x.dx;
}
void fare::alan(int x1, int y1, int x2, int y2)
{
komut(7,0,x1,x2); //fare kullanimina yatay ve dikey bolge
komut(8,0,y1,y2); //siniralamasi getir
}
void fare::durum(int d)
{
komut(d); //fareyi gizle(d=2) ve goster(d=1)
}
void fare::konumAl(int &x, int &y, bool &tus)
{
komut(3,tus,x,y); // farenin konumu ve hangi tusuna tiklandi
bx &= 0x01;
if(bx == SOLTUS) //sol tusa tikli ise ciz
tus = TRUE;
else
tus = FALSE;
x = cx;
y = dx;
}
void fare::~fare()
{
durum(2); //gizle
}







#include <graphics.h>
#include <stdio.h>
#include <conio.h>
#include <math.h>
fare frNesne;



class core {
private:
      int  x1,x2,y1,y2,tus,renk;
public:
	core();
	~core();
	void renkAta(int al);
	void dikdortgen();
	void cember();
	void elips();
	void serbest();
	void cizgi();
	void sil();
	void yeni();
	void kaydet();
	void kayitac();
	void menu();
};
core::~core() {}
core::core() {renk=1;}
void core::renkAta(int al)
{
	renk = al;
}
void core::dikdortgen()
{
	
frNesne.konumAl(x1,y1,tus); 
if(tus==1) { x2=x1; y2=y1; } //ilk basýlan noktanýn koord. tut

while(tus==TRUE)
 {
	   frNesne.konumAl(x1,y1,tus);//konum gunc.
	   if(x1<100)continue;  
	   if(x2<100)continue; 
 else
    {
     if(tus==0)
	  {
       setcolor(renk);
       frNesne.durum(2);
	   rectangle(x1,y1,x2,y2); 
	   frNesne.durum(1);
	 }
   }
 }
}

void core::cember()
{
	
frNesne.konumAl(x1,y1,tus);  
if(tus==TRUE) x2=x1;y2=y1;   

while(tus==TRUE)  
 {
frNesne.konumAl(x1,y1,tus);
if(x1<100) continue; 
if(x2<100) continue;
  else
   {
	if(tus==0)
	 {
	   frNesne.durum(2);
	   setcolor(renk);
	   circle(fabs(x2+x1)/2,fabs(y2+y1)/2,fabs(x2-x1)/2);  
	   frNesne.durum(1);
	 }
   }
 }
}

void core::elips()
{
	
frNesne.konumAl(x1,y1,tus);
if(tus==TRUE) x2=x1;y2=y1;  

while(tus==TRUE)
 {
  frNesne.konumAl(x1,y1,tus);
  if(x1<100) continue;
  if(x2<100) continue;
   else
    {
	 if(tus==0)
	  {
	   frNesne.durum(2);
	   setcolor(renk);
	   ellipse(fabs(x2+x1)/2,fabs(y2+y1)/2,0,360,fabs(x2-x1)/2,fabs(y2-y1)/2);
	   frNesne.durum(1);
	  }
    }
  }
}

void core::cizgi()
{
	
frNesne.konumAl(x1,y1,tus);
if(tus==TRUE) {x2=x1;y2=y1;}  

while((tus==TRUE))
 {
  frNesne.konumAl(x1,y1,tus);
  if(x1<100) continue;
  if(x2<100) continue;
   else
    {
     if(tus==0)
      {
	   frNesne.durum(2);
	   setcolor(renk);
	   line(x2,y2,x1,y1);
	   frNesne.durum(1);
	  }
    }
  }
}
void core::serbest()
{
	
frNesne.konumAl(x1,y1,tus);
setcolor(renk);
moveto(x1,y1); 

while(tus==1)
 {
  if(x1<=100) break;
  frNesne.durum(2); 
  lineto(x1,y1); 
  frNesne.konumAl(x1,y1,tus); 
  frNesne.durum(1);
 }
}
void core::sil()
{

frNesne.konumAl(x1,y1,tus);
 while((tus==1)&&(x1>110))
  {
   frNesne.durum(2);
   setcolor(getbkcolor());
   bar(x1-10,y1-10,x1+10,y1+10);  
   setfillstyle(SOLID_FILL,getbkcolor());
   frNesne.konumAl(x1,y1,tus);
  }
frNesne.durum(1);
}
void core::kaydet()
{
  FILE *dosya = fopen("c:\\kayit.txt", "w+"); 
  if(!dosya) {outtextxy(100,100,"dosya acilmadi"); return;}
  frNesne.durum(2);
	for(int i=0;i<=getmaxy();i++)
	{
		for(int h=101;h<=getmaxx(); h++) 
		 {
		  fprintf(dosya,"%d",getpixel(h,i)); 
		  fprintf(dosya,"%s"," ");    
		 }
	}
	
  fclose(dosya); 
  frNesne.durum(1);  
}
void core::kayitac()
{
  int oku;
  FILE *dosya = fopen("c:\\kayit.txt", "r"); 
  frNesne.durum(2); 
  if(!dosya) { outtextxy(100,100,"dosya acilmadi"); return;}
	 for(int i=0;i<=getmaxy();i++)
	  {
		for(int h=101;h<=getmaxx(); h++)
		 {
		  fscanf(dosya,"%d",&oku);
		  putpixel(h,i,oku);
		 }
	  }
  fclose(dosya); 
  frNesne.durum(1); 
}
void core::menu()
{

frNesne.alan(1, 1, getmaxx()-1, getmaxy()-1);  
setbkcolor(CYAN);
setcolor(WHITE); 
line(38,300,38,360);

int i;
for(i=0;i<480;i+=60){rectangle(0,i,80,i+60);} 

setcolor(WHITE); 
rectangle(5,5,75,55);  
circle(40,90,25); //M(40,90),r
ellipse(40,150,0,360,35,20);//M(40,150... 0,360... 35,20  yarýçap)

settextstyle(6,1,5); //font,yon,boyut
outtextxy(5,220,"S");  
i=4; 
settextstyle(0,0,0); 

line(5,245,75,295); 

outtextxy(1,330,"YENI");
outtextxy(40,330,"SIL");
outtextxy(1,390,"KAYIT AC");
outtextxy(1,450,"KAYDET");

setcolor(15);
line(100,0,100,getmaxy());

setcolor(4);
rectangle(82,50,97,65);
setfillstyle(SOLID_FILL,4);
floodfill(85,55,4);

setcolor(8);
rectangle(82,100,97,115);
setfillstyle(SOLID_FILL,8);
floodfill(85,105,8);

setcolor(6);
rectangle(82,150,97,165);
setfillstyle(SOLID_FILL,6);
floodfill(85,155,6);

setcolor(1);
rectangle(82,200,97,215);
setfillstyle(SOLID_FILL,1);
floodfill(85,205,1);

setcolor(5);
rectangle(82,250,97,265);
setfillstyle(SOLID_FILL,5);
floodfill(85,255,5);

setcolor(12);
rectangle(82,300,97,315);
setfillstyle(SOLID_FILL,12);
floodfill(85,305,12);

setcolor(14);
rectangle(82,350,97,365);
setfillstyle(SOLID_FILL,14);
floodfill(85,355,14);

setcolor(7);
rectangle(82,400,97,415);
setfillstyle(SOLID_FILL,7);
floodfill(85,405,7);


}
int main()
{
core create ;

int tus, x1 = 1, y1 = 1,i,renk=1;  
i = 4;
grafik grNesne;
grNesne.giris(); 
fare frNesne;  
create.menu();
frNesne.durum(1); 

do
{
frNesne.konumAl(x1,y1,tus);

if((x1<80)) 
{

     if((y1<60)&&(y1>0)   &&(tus==TRUE)) i=1;  //dortgen   
else if((y1<120)&&(y1>60) &&(tus==TRUE)) i=2;  //cember
else if((y1<180)&&(y1>120)&&(tus==TRUE)) i=3;  //elips
else if((y1<240)&&(y1>180)&&(tus==TRUE)) i=4;  //serbest
else if((y1<300)&&(y1>240)&&(tus==TRUE)) i=5;  //cizgi
else if((y1<360)&&(y1>300)&&(x1<38)&&(x1>0)&&(tus==TRUE)) // yeni
	{
     setcolor(getbkcolor()); 
     for(int z=1;z<479;z++){line(101,z,638,z);} 
    }
else if((y1<360)&&(y1>300)&&(x1<80)&&(x1>38)){if(tus==TRUE)i=9;}  // silgi
else if((y1<480)&&(y1>420)&&(tus==TRUE))  create.kaydet(); // kayit
else if((y1<420)&&(y1>360)&&(tus==TRUE)) create.kayitac(); // kayit ac

} //if end 

else //cizim ekranina
{
	 if(i==4) create.serbest();  	
else if(i==1) create.dikdortgen(); 
else if(i==2) create.cember();
else if(i==3) create.elips();
else if(i==5) create.cizgi();
else if(i==9) create.sil();

if((x1<97)&&(x1>82)&&(y1<65)&&(y1>50)&&(tus==1))   create.renkAta(4); 
if((x1<97)&&(x1>82)&&(y1<115)&&(y1>100)&&(tus==1)) create.renkAta(8);
if((x1<97)&&(x1>82)&&(y1<165)&&(y1>150)&&(tus==1)) create.renkAta(6);
if((x1<97)&&(x1>82)&&(y1<215)&&(y1>200)&&(tus==1)) create.renkAta(1);
if((x1<97)&&(x1>82)&&(y1<265)&&(y1>250)&&(tus==1)) create.renkAta(5);
if((x1<97)&&(x1>82)&&(y1<315)&&(y1>300)&&(tus==1)) create.renkAta(12);
if((x1<97)&&(x1>82)&&(y1<365)&&(y1>350)&&(tus==1)) create.renkAta(14);
if((x1<97)&&(x1>82)&&(y1<425)&&(y1>400)&&(tus==1)) create.renkAta(7);
frNesne.durum(1);
}
}while(!kbhit()); 
grNesne.cikis();
return 0;
}

