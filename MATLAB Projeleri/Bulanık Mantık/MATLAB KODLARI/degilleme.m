function [ x1, y ] = degilleme( x1, y1)
y = [];
for k=1:length(x1)
   y(k)= 1 - y1(k);
end  
end

