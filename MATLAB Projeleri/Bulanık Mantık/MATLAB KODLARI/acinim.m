function [ acinim_x, acinim_y  ] = acinim( x, y, a,b,c )

% a -> x^2
% b -> x
% c -> sabit

acinim_x = a*(x.^2) + b*(x) + c;
acinim_y = y;

for k=1:length(acinim_x)
    for i=1:length(acinim_x)
       if(acinim_x(k) == acinim_x(i))
           acinim_y(i) = max(acinim_y(k), acinim_y(i));
           acinim_y(k) = acinim_y(i);
           end
           
       end
       
    end
  

subplot(211);
plot(x,y);

subplot(212);
plot(acinim_x,acinim_y);
axis([-10,50,0,1]);

end

