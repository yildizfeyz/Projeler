#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <sys/types.h>



 int main()
 {

	
        int iX,iY;
int cz;
printf("Çözürnürlük(AxA): ");

scanf("%d",&cz);
system("date +\"%T.%N\"");
        const int iXmax = cz; 
        const int iYmax = cz;
      
        double Cx,Cy;
        const double CxMin=-2.5;
        const double CxMax=1.5;
        const double CyMin=-2.0;
        const double CyMax=2.0;
        
        double PixelWidth=(CxMax-CxMin)/iXmax;
        double PixelHeight=(CyMax-CyMin)/iYmax;
      
        const int MaxColorComponentValue=255; 
        FILE * fp2;
        char *filename="sirali.ppm";
        char *comment="# ";
        char color[3];
        
        double Zx, Zy;
        double Zx2, Zy2;
       
		int gl = 0;
        int Iteration;
        const int IterationMax=200;
       
        const double EscapeRadius=2;
        double ER2=EscapeRadius*EscapeRadius;
       
        fp2= fopen(filename,"wb"); 
       
        fprintf(fp2,"P6\n %s\n %d\n %d\n %d\n",comment,cz,cz,MaxColorComponentValue);
        
        for(iY=0;iY<iYmax;iY++)
        {
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
                           color[0]=0;
                           color[1]=0;
                           color[2]=0;  
						   
                        }
                     else 
                        { 
                             color[0]=255; 
                             color[1]=255;    
                             color[2]=255; 			 
                        };
						
                        fwrite(color,1,3,fp2);
                        
                }
        }
		
		
        	fclose(fp2);
		
		
system("date +\"%T.%N\"");
printf("Tamamlandı\n");

		
        return 0;
 }
