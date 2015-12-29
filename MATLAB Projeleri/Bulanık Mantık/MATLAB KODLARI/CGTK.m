function[w, z]= CGTK(Ax, Ay, Bx, By, Cx, Cy, k)
p = 1;
%Cy = [];
%Cx = [];
Cx2 = Cx;
Cy2 = Cy;
w = [];
z = [];
Cxler = [];
Cyler = [];
  for i=1:k  %k kural
  		y=[];
		x1 = Ax(:,i); % satýr þeklinde yazýyoruz sütun alýyor 
        x2 = Bx(:,i);
		y1 = Ay(:,i);
		y2 = By(:,i);
        subplot(k+1,2,p);
        p = p + 1;
        plot(x1,y1,x2,y2);
        title('Giriþ - Kural Kesiþimi');
        %subplot(3,2,p);
        %p = p + 1;
        %plot(x2,y2);
    	if( x1 == x2 )
       		 for h=1:length(x1)
          		 y(h)=min(y1(h),y2(h));
       		 end 
         	 maxy(i) = max(y);
	
        end
        %Cy = CY(:,i);
        %Cx = CX(:,i);
         
         for f=1:length(Cx)
         if(Cy(f) > maxy(i))
            Cy2(f) = maxy(i);
         else Cy2(f) = Cy(f);
        
         for f=1:length(Cx)
             if(Cy(f) == maxy(i))
                 w(i) = maxy(i); z(i) = Cx(f); break; end 
         end
         
            
         end
         end
         subplot(k+1,2,p);
         p = p + 1;
         plot(Cx2,Cy2);
         title('Çýkýþ');
         axis([-10,10,0,1]);
        Cxler(:,i) = Cx2;
		Cyler(:,i) = Cy2;
  end
        
      x1 = Cx;
      x1 = transpose(x1);
      y1 = Cy;
        for j=1:k
        
        %birlesim
        y=[];
        x=[];
%x1 = Cxler(:,1);
x2 = Cxler(:,j);
%y1 = Cyler(:,1);
y2 = Cyler(:,j);
    if( x1 == x2 )
        
        x=x1;
       for c=1:length(x1)
           y(c)=min(y1(c),y2(c));
       end    
    
      
       
    end
         y1 = y;
        end
    subplot(k+1,2,(k+1)*2);
    plot(x,y);
        
    title('Minimum Çýkýþ');
     
        
axis([-10,10,0,1]);
    
 
end
