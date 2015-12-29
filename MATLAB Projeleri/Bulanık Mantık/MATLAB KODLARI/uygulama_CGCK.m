function [ output_args ] = uygulama_CGCK( input_args )
%UYGULAMA_CGCK Summary of this function goes here
%   Detailed explanation goes here
[Ax(:,1), Ay(:,1)] = ucgen(0,2,4,1,1);
[Bx(:,1), By(:,1)] = ucgen(2,4,6,1,1);

[Ax(:,2), Ay(:,2)] = gaussian(0,2,1,1);
[Bx(:,2), By(:,2)] = gaussian(6,2,6,1);

[Ax(:,3), Ay(:,3)] = yamuk(0,2,4,6,1,1);
[Bx(:,3), By(:,3)] = yamuk(2,5,6,9,1,1);

[CX(:,1), CY(:,1)] = gaussian(0,2,1,1);
[CX(:,2), CY(:,2)] = ucgen(2,4,6,1,1);
[CX(:,3), CY(:,3)] = yamuk(-1,2,3,4,1,1);

CGCK(Ax, Ay, Bx, By, CX, CY, 3);

end

