function[w, z]= CGCK(Ax, Ay, Bx, By, CX, CY , k)
p = 1;
Cy = [];
Cx = [];
w = [];
z = [];
Cxler = [];
Cyler = [];

 y=[];
 Cxnokta = [];
        x=[];
  for i=1:k  %k kural
  		y=[];
		x1 = Ax(:,i); % sat�r �eklinde yaz�yoruz s�tun al�yor 
        x2 = Bx(:,i);
		y1 = Ay(:,i);
		y2 = By(:,i);
        subplot(k+1,2,p);
        p = p + 1;
        plot(x1,y1,x2,y2);
        title('Giri� - Kural Kesi�imi');
        %subplot(3,2,p);
        %p = p + 1;
        %plot(x2,y2);
    	if( x1 == x2 )
       		 for h=1:length(x1)
          		 y(h)=min(y1(h),y2(h));
       		 end 
         	 maxy(i) = max(y);
	
        end
        Cy = CY(:,i);
        Cx = CX(:,i);
        % Cx tepe noktas� bulunuyor
        maxCy = 0;
        minindex = 0;
        for t=1:length(Cy);
            if(maxCy < Cy(t)) maxCy = Cy(t);    end
        end
        for t=1:length(Cy);
            if(maxCy == Cy(t)) minindex = t; break;   end
        end
        
        for t=minindex:length(Cy);
            if(maxCy ~= Cy(t)) maxindex = t; break;   end
        end
        
        
  
        Cxnokta(i) = (Cx(minindex) + Cx(maxindex)) / 2;
        
        % Cx tepe noktas� bulunuyor B�TT�
        
         for f=1:length(Cx)
         if(Cy(f) > maxy(i))
            Cy(f) = maxy(i);
          
         
        
            
         end
         end
         subplot(k+1,2,p);
         p = p + 1;
        
        
         
         plot(Cx,Cy);
         title('��k��');
         axis([-10,10,0,1]);
        Cxler(:,i) = Cx;
		Cyler(:,i) = Cy;
  end
  
  
  

  
 
      x1 = -10:0.1:10;
      x1 = transpose(x1);
      y1 = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0];
        
      
      
      
      for j=1:k
        x2 = Cxler(:,j);
        y2 = Cyler(:,j);
         if( x1 == x2 )
         x=x1;
            for c=1:length(x1)
                y(c)=max(y1(c),y2(c));
            end    
    
      
       
         end
         y1 = y;
        end
    subplot(k+1,2,(k+1)*2);
    plot(x,y);
       title('��k��lar�n Birle�imi');
axis([-10,10,0,1]);
   
   
 
end
