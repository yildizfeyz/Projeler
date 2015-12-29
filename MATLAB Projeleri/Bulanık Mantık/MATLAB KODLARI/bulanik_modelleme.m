function[w, z]= bulanik_modelleme(Ax, Ay, Bx, By, CX, CY , k, xgiris, ygiris, sugeno_p, sugeno_q, sugeno_r)
p = 1;
Cy = [];
Cx = [];
w = [];
z = [];
Cxler = [];
Cyler = [];
tsukamoto_w = [];
tsukamoto_z = [];

 y=[];
 Cxnokta = [];
        x=[];
  for i=1:k  %k kural
  		y=[];
		x1 = Ax(:,i); % satýr þeklinde yazýyoruz sütun alýyor 
        x2 = Bx(:,i);
		y1 = Ay(:,i);
		y2 = By(:,i);
        subplot(k+1,3,p);
        plot(x1,y1);
       
        if(i == k) xlabel('x giris: 1'); end
        p = p + 1;
        subplot(k+1,3,p);
        plot(x2,y2);
        if(i == k) xlabel('y giris: 3'); end
        p = p + 1;
       
        Cy = CY(:,i);
        Cx = CX(:,i);
        % Cx tepe noktasý bulunuyor
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
        
        % Cx tepe noktasý bulunuyor BÝTTÝ
        xkes = 0;
        ykes = 0;
         for f=1:length(x1)
         if(x1(f) >= xgiris)
            xkes = y1(f); break;
         end
         end
     
         for f=1:length(x2)
         if(x2(f) >= ygiris)
            ykes = y2(f); break;
         end
         end
         
         kes = min(xkes, ykes);
         
         for f=1:length(Cx)
           if(Cy(f) >= kes)
            tsukamoto_w(i) = Cy(f);
            tsukamoto_z(i) = Cx(f);
         
        
            
         end
         end
         
          for f=1:length(Cx)
           if(Cy(f) > kes)
            Cy(f) = kes;
          
         
        
            
         end
         end
         
         subplot(k+1,3,p);
         p = p + 1;
        
        
         xlabel('sonuc');
         plot(Cx,Cy);
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
    subplot(k+1,3,(k+1)*3);
    plot(x,y);
       
axis([-10,10,0,1]);
      %mamdani
      pay = 0;
      payda = 0;
  for t=1:length(Cxnokta)
      for u=1:length(x)
          if((x(u) + 0.6 > Cxnokta(t)) &&  (x(u) - 0.6 < Cxnokta(t) )) pay = pay + (x(u)*y(u)); payda = payda + y(u);  end   
      end
  end
       
  
    snc = pay/payda;
   
    fprintf('Mamdani Sonucu: %f\n', snc);
   %mamdani hesaplandý
    
   %Tsukamoto 
     pay = 0;
      payda = 0;
  for t=1:length(tsukamoto_w)
      pay = pay + (tsukamoto_w(t) * tsukamoto_z(t) );
      payda = payda + tsukamoto_w(t);
  end
       
  
    snc = pay/payda;
   
    fprintf('Tsukamoto Sonucu: %f\n', snc);
    
    %Tsukamoto hesaplandý
    
    
    % Sugeno
      pay = 0;
      payda = 0;
      sugeno_z = []; 
      for t=1:length(tsukamoto_w)
        sugeno_z(t) = sugeno_p(t)*xgiris + sugeno_q(t)*ygiris + sugeno_r(t);
      end
      
  for t=1:length(tsukamoto_w)
      pay = pay + (tsukamoto_w(t) * sugeno_z(t) );
      payda = payda + tsukamoto_w(t);
  end
       
  
    snc = pay/payda;
   
    fprintf('Sugeno Sonucu: %f\n', snc);
    % Sugeno Hesaplandý
 xlabel('Sonuçlar komut ekranýnda görülmektedir.');
end
