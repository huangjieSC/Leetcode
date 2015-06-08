public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = 0;
        int overlap = overlapArea(A,B,C,D,E,F,G,H);
        area = Math.abs((C-A)*(D-B)) + Math.abs((G-E)*(H-F)) - Math.abs(overlap);
        return area;
    }
    
    public int overlapArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = 0;
        int leftX = 0, rightX  = 0, leftY = 0, rightY = 0;
        
        if(G<=C && A<=E && F>=B && H<=D){
            area = (G-E)*(H-F);
        }
        else if(A>=E && C<=G && B>=F && D<=H){
            area = (C-A)*(D-B);
        }
        else if(A<=E && B>=F && E<=C){
            leftX = E;
            leftY = B;
            rightX = C<=G?C:G;
            rightY = D<=H?D:H;
            area = (rightY-leftY)*(rightX-leftX);
        }
        else if(A<=E && B<=F && E<=C){
            leftX = E;
            leftY = F;
            rightX = C<=G?C:G;
            rightY = D<=H?D:H;
            area = (rightY-leftY)*(rightX-leftX);
        }
        else if(G<=C && G>=A && B>=F){
            leftX = A;
            leftY = B;
            rightX = C<=G?C:G;
            rightY = D<=H?D:H;
            area = (rightY-leftY)*(rightX-leftX);
        }
        else if(G<=C && G>=A && B<=F){
            leftX = A;
            leftY = F;
            rightX = C<=G?C:G;
            rightY = D<=H?D:H;
            area = (rightY-leftY)*(rightX-leftX);
        }
        else if(E<=A && G>=C && H<=D && H>=B){
            area = (H-B)*(C-A);
        }
        else if(E<=A && G>=C && F<=D && F>=B){
            area = (D-F)*(C-A);
        }
        else if(A<=E && C>=G && H<=D && H>=B){
            area = (H-B)*(G-E);
        }
        else if(A<=E && C>=G && F<=D && F>=B){
            area = (D-F)*(G-E);
        }
       else     
            area = 0;
        return area;
    }
}
