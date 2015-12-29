function [ x3,y3 ] = tekgiristekcikis( x1, y1, x2, y2, x3, y3 )
%TEKGÝRÝSTEKCÝKÝS Summary of this function goes here
%   Detailed explanation goes here

subplot(121);
plot(x1,y1,x2,y2);
title('Giris - Kural Keþisimi');
 y=[];
    if( x1 == x2 )
        x=x1;
       for k=1:length(x1)
           y(k)=min(y1(k),y2(k));
       end  
	maxy = max(y);
    
    for i=1:length(x3)
      if(y3(i) > maxy)
      	y3(i) = maxy;
      end
    end
    subplot(122);
plot(x3,y3);
title('Sonuç Kümesi');

axis([-10,10,0,1]);

end

