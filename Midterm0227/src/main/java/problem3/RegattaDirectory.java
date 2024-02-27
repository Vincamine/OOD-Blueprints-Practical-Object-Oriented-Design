package problem3;

import java.util.ArrayList;

public class RegattaDirectory implements RegattaDirectoryImplement {
    protected ArrayList<Regatta> regattaCollection;

    public RegattaDirectory() {this.regattaCollection = new ArrayList<Regatta>();}




    /**
     * Count the number of Regattas in the RegattaDirectoryImplement.
     * @return Integer
     */
    @Override
    public Integer countNumberOfRegatta() {
        return this.regattaCollection.size();
    }

    /**
     * Checks if a Regatta with the requested name exists in the RegattaDirectoryImplement.
     * @return Boolean
     */
    @Override
    public Boolean checkRegatta(String regattaNam) {
        for(Regatta regatta : regattaCollection){
            if(regatta.getRegattaName().equals(regattaNam)){
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * Add a Regatta to the RegattaDirectoryImplement. Please note that RegattaDirectoryImplement
     * does not allow duplicate Regattas.
     * @return RegattaDirectoryImplement
     */
    @Override
    public RegattaDirectoryImplement addRegatta(Regatta regatta) {
        if(!checkRegatta(regatta.getRegattaName())){
            this.regattaCollection.add(regatta);
        }
        //return (RegattaDirectoryImplement) this.RegattaCollection;
        return this;
    }

}
