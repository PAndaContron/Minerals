
package org.terasology.minerals.generation.oreproviders;

import org.terasology.minerals.generation.OreFacet;
import org.terasology.minerals.generation.OreProvider;
import org.terasology.utilities.procedural.SimplexNoise;
import org.terasology.world.generation.Border3D;
import org.terasology.world.generation.GeneratingRegion;
import org.terasology.world.generation.Produces;
import org.terasology.world.generator.plugin.RegisterPlugin;

@RegisterPlugin
@Produces(OreFacet.Chrysocolla.class)
public class Chrysocolla extends OreProvider {
    protected int index = 6;
    
    @Override
    public void setSeed(long seed) {
        oreNoise = new SimplexNoise(seed + index*57);
    }

    @Override
    public void process(GeneratingRegion region) {
        Border3D border = region.getBorderForFacet(OreFacet.Chrysocolla.class);
        OreFacet facet = baseProcess(region, border, index);
        OreFacet.Chrysocolla classFacet = facet.new Chrysocolla(region.getRegion(), border);
        classFacet.set(facet.getInternal());
        region.setRegionFacet(OreFacet.Chrysocolla.class, classFacet);
    }
}
