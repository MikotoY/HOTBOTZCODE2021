package frc.robot.profiling;

public class TrapezoidProfile implements MotionProfile {
	double startPos;
	double endPos;
	double startV;
	double endV;
	double vCruise;
	double acc;
	double setVCruise;
	double tRise;
	double tCruise;
	double tFall;
	double dRise, dFall, dCruise;
	public double scalar = 1;
	
	public TrapezoidProfile(double startPos, double endPos, double startV, double endV, double vCruise, double acc) {
		 this.acc = Math.abs(acc);
		 this.startPos=startPos;
		 this.endPos=endPos;
		 this.startV=startV;
		 this.endV=endV;
		 //setting the distance
		 double d = endPos-startPos;
		 //setting the cruise direction
		 double cdir = Math.signum(d-rdist(startV, endV));
		 //setting the theoretical cruise velocity
		 double vtc = cdir*vCruise;
		 if(cdir==0) {
			 vtc=startV;
		 }
		 double xramp = rdist(startV, vtc)+rdist(vtc, endV);
		 //calculating the overshoot
		 double overshoot = (xramp-d)*cdir;
		 
		 if(overshoot>0) {
			 setVCruise = cdir*Math.sqrt(vCruise*vCruise+cdir*Math.signum(startV-vtc)*this.acc*overshoot);
			 tCruise = 0;
		 }
		 else {
			 setVCruise = vtc;
			 
			 if(d==xramp) {
				 tCruise = 0;
			 }
				 else {
					 tCruise = (d-xramp)/setVCruise;
				 }	 
		 }
		 tRise = Math.abs(setVCruise-startV)/this.acc;
		 tFall = Math.abs(setVCruise-endV)/this.acc;
		 dRise = rdist(startV, setVCruise);
		 dCruise = setVCruise*tCruise;
		 dFall = rdist(setVCruise, endV);
	}
	
	private double rdist(double v1, double v2) {
		return Math.abs(v1-v2)*(v1+v2)/(2*acc);
	}
	
	public double currentP(double time) {
		double p;
		if(time<tRise) {
			p = startPos+startV*time+Math.signum(setVCruise-startV)*acc/2*time*time;
		}
		else if(time<tRise+tCruise){
			p = startPos+dRise+setVCruise*(time-tRise);
			}
		else if(time<tRise+tCruise+tFall){
			p = startPos+dRise+dCruise+setVCruise*(time-tRise-tCruise)+Math.signum(endV-setVCruise)*acc/2*((time-tRise-tCruise)*(time-tRise-tCruise));
		}
		else {
			p = endPos;
		}
		return p*scalar;
	}
	
	public double currentV(double time) {
		double v;
		if(time<tRise) {
			v = startV+Math.signum(setVCruise-startV)*acc*time;
		}
		else if(time<tRise+tCruise) {
			v = setVCruise;
		}
		else if(time<tRise+tCruise+tFall) {
			v = setVCruise+Math.signum(endV-setVCruise)*acc*(time-tRise-tCruise);
		}
		else {
			v = endV;
		}
		return v*scalar;
	}
	
	public void setScalar(double scalar) {
		this.scalar = scalar;
	}
	
	public double totalTime() {
		return tRise+tCruise+tFall;
	}

	@Override
	public double currentA(double t) {
		return 0;
	}
	
		
	}
	
