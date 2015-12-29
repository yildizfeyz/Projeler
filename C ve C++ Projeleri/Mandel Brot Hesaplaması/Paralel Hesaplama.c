#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <sys/types.h>
#include <unistd.h> 
#include <time.h>


char piksel[3000];

 




void hesapla(int min,int max,int* _ortak,int* _senk)
{

 	int iX,iY;
        const int iXmax = 1000; 
        const int iYmax = 1000;
      
        double Cx,Cy;
        const double CxMin=-2.5;
        const double CxMax=1.5;
        const double CyMin=-2.0;
        const double CyMax=2.0;
        
        double PixelWidth=(CxMax-CxMin)/iXmax;
        double PixelHeight=(CyMax-CyMin)/iYmax;
      
        const int MaxColorComponentValue=255; 
        
        
        
        
        double Zx, Zy;
        double Zx2, Zy2;
       
		
        int Iteration;
        const int IterationMax=200;
       
        const double EscapeRadius=2;
        double ER2=EscapeRadius*EscapeRadius;
       
        
        int syc;
	syc = 0;
        for(iY=min;iY<iYmax;iY++)
        {
		if(iY == max) break;
		syc = 0;
             Cy=CyMin + iY*PixelHeight;
             if (fabs((double)Cy)< PixelHeight/2) Cy=0.0; 
             for(iX=0;iX<iXmax;iX++)
             {         
			
                        Cx=CxMin + iX*PixelWidth; 
                        Zx=0.0;
                        Zy=0.0;
                        Zx2=Zx*Zx;
                        Zy2=Zy*Zy;
                        
                        for (Iteration=0;Iteration<IterationMax && ((Zx2+Zy2)<ER2);Iteration++)
                        {
                            Zy=2*Zx*Zy + Cy;
                            Zx=Zx2-Zy2 +Cx;
                            Zx2=Zx*Zx;
                            Zy2=Zy*Zy;
                        };
                        
                        if (Iteration==IterationMax)
                        { 
                           piksel[syc++]=0;
                           piksel[syc++]=0;
                           piksel[syc++]=0;  
						   
                        }
                     else 
                        { 
                             piksel[syc++]=255; 
                             piksel[syc++]=255;    
                             piksel[syc++]=255; 
							 
                        };
		
                        
                        
                }

write(_senk[1], "bitti", 5);
write(_ortak[1], piksel, 3000);
        }




exit(1);
}


void yazdir(FILE* fp,int adim,int* _ortak,char* _obuf,int* _senk,char* _senkbuf, int fps, int* tamam)
{

 


       
int p = 0;
int u = 1;
while(u)
{
read(_senk[0], _senkbuf, 5); 

while(!strcmp(_senkbuf,"bekle"))  read(_senk[0], _senkbuf, 5);  
++p;
if(p == adim+1) break;
write(_senk[1], "bekle", 5);
read(_ortak[0], _obuf, 3000);
fseek (fp , fps, SEEK_SET );
fwrite(_obuf,1,3000,fp);
fps+=3000;



}


write(tamam[1], "bitti", 5);
}




 int main()
 {

printf("Hem SIMD hem MIMD Program\nHesaplama farklı çocuk süreçlere ve dosyaya yazma da farklı çocuk süreçlere dağıtılacaktır.\n");



	
int is;
printf("hesaplama ve haberleşme kac alt process bolunsun?(x:int): ");
scanf("%d",&is);
//is = 2;
system("date +\"%T.%N\"");



int tamam[is][2]; 
char buf[is][30];


int fps = 24;
int j=0;
FILE *f[is];

int _ortak[is][2];

int _senk[is][2];

char _senkbuf[is][5];

int pay = (1000/is)*3;
char _buf[is][3000];
char *filename="simdvemimd.ppm";
for(j = 0; j < is; j++)
{
	f[j] = fopen(filename,"wb"); 
	pipe(tamam[j]);
	pipe(_ortak[j]); 
	pipe(_senk[j]); 
	write(_senk[j][1], "bitti", 5);
	write(tamam[j][1], "bekle", 5);
}


        char *comment="# ";
        fprintf(f[0],"P6\n %s\n %d\n %d\n %d\n",comment,1000,1000,255);


int min = 0;
int adim = 1000/is;
int max;

for(j=0;j<is;j++)
{

max = min + adim;
	if(fork() == 0) { hesapla(min, max, _ortak[j], _senk[j]); exit(1); } 

	if(fork() == 0) { yazdir(f[j],adim, _ortak[j], _buf[j], _senk[j], _senkbuf[j], fps, tamam[j]); exit(1); }
	fps = fps + 3000*(1000/is);
min = min + adim;
}

for(j = 0; j < is; j++)
{
read(tamam[j][0], buf[j], 5); 

while(!strcmp(buf[j],"bekle"))  read(tamam[j][0], buf[j], 5); 
}

  


system("date +\"%T.%N\"");
printf("Tamamlandi\n");
	getchar();

        return 0;
 }
