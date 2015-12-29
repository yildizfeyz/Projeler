function [x1, y  ] = birlesim(  x1, y1, x2, y2 )
 y=[];
 for k=1:length(x1)
   y(k)=max(y1(k),y2(k));
 end    
end

