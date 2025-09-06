class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
     int area1 = (ax2-ax1) * (ay2-ay1);
     int area2 = (bx2-bx1) * (by2-by1);
     int cx1,cx2,cy1,cy2;
     cx1=Math.max(ax1,bx1);
     cy1=Math.max(ay1,by1);
     cx2=Math.min(ax2,bx2);
     cy2=Math.min(ay2,by2);
     int area3 = (cx2-cx1) * (cy2-cy1);
     if(cx2-cx1<0 || cy2-cy1<0) {
        area3=0;
    }
     return area1+area2-area3;
    }
}