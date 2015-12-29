function [  ] = uygulama_bulanikModelleme(  )
%UYGULAMA Summary of this function goes here
%   Detailed explanation goes here

[Ax(:,1), Ay(:,1)] = ucgen(0,1,2,1,1);
[Bx(:,1), By(:,1)] = ucgen(0,3.2,7,1,1);

[Ax(:,2), Ay(:,2)] = ucgen(0,2,4,1,1);
[Bx(:,2), By(:,2)] = ucgen(2,4,6,1,1);

[Ax(:,3), Ay(:,3)] = ucgen(0,1,2,1,1);
[Bx(:,3), By(:,3)] = ucgen(0,2,4,1,1);

[CX(:,1), CY(:,1)] = ucgen(-2,0,2,1,1);
[CX(:,2), CY(:,2)] = yamuk(-4,-2,0,2,1,1);
[CX(:,3), CY(:,3)] = gaussian(0,3,3,1);

kuralsayisi = 3;
xgiris = 1;
ygiris = 3;
sugeno_p = [-1 -1 -1];
sugeno_q = [1.5 1.5 1.5];
sugeno_r = [1 1 1];
bulanik_modelleme(Ax,Ay,Bx,By,CX,CY,kuralsayisi, xgiris,ygiris, sugeno_p, sugeno_q, sugeno_r);

end

