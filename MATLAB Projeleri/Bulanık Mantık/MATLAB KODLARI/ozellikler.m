	function [  ] = ozellikler( x1, y1, alfa )
%OZELLÝKLER Summary of this function goes here
%   Detailed explanation goes here

y = [];
fprintf('Göbek = ');
  
for k=1:length(x1)
    
    if(y1(k) == 1)
        fprintf('%d ', x1(k));
    end
    %y(k)= 1 - y1(k);
end  
fprintf('\nGeçiþ Noktalarý= ');
for k=1:length(x1)
    
    if(y1(k) == 0.5)
        fprintf('%.1f ', x1(k));
    end
    %y(k)= 1 - y1(k);
end 
fprintf('\nSýnýr= ');
for k=1:length(x1)
    
    if(y1(k) ~= 0 && y1(k) ~= 1)
        fprintf('%.1f ', abs(x1(k)));
    end
    %y(k)= 1 - y1(k);
end 
fprintf('\nDestek= ');
for k=1:length(x1)
    
    if(y1(k) > 0)
        fprintf('%.1f ', abs(x1(k)));
    end
    %y(k)= 1 - y1(k);
end 
fprintf('\nalfa kumesi= ');
for k=1:length(x1)
    
    if(y1(k) >= alfa)
        fprintf('%f ', abs(x1(k)));
    end
    %y(k)= 1 - y1(k);
end 
fprintf('\nbant genisligi= ');
for k=1:length(x1)
    
    if(y1(k) >= 0.5)
        fprintf('%.1f ', abs(x1(k)));
    end
    %y(k)= 1 - y1(k);
end 
fprintf('\nyukseklik= ');
derece = 0;
for k=1:length(x1)
    
    if(y1(k) > derece)
        derece = y1(k);
    end
    %y(k)= 1 - y1(k);
end 
fprintf('%.1f ', derece);
fprintf('\n');
if(derece == 1) fprintf('Bu normal bir kümedir\n'); else fprintf('Bu normal bir küme deðildir.\n');
end

