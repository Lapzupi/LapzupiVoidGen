package de.xtkq.voidgen.generator.instances;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import de.xtkq.voidgen.VoidGen;
import de.xtkq.voidgen.generator.annotations.VoidChunkGenInfo;
import de.xtkq.voidgen.generator.interfaces.ChunkGen3DExtended;
import de.xtkq.voidgen.generator.settings.ChunkGenSettings;
import org.apache.commons.lang.StringUtils;
import org.bukkit.World;

import java.util.Objects;
import java.util.Random;

@VoidChunkGenInfo(versions = {"1.17", "1.17.1"})
public class VoidChunkGen_1_17 extends ChunkGen3DExtended {

    public VoidChunkGen_1_17(String paramIdentifier) {
        Gson gson = new Gson();

        if (StringUtils.isBlank(paramIdentifier)) {
            this.chunkGenSettings = new ChunkGenSettings();
            VoidGen.getVoidGen().getLogger().info("Generator settings have not been set. Using default values:");
        } else {
            try {
                this.chunkGenSettings = gson.fromJson(paramIdentifier, ChunkGenSettings.class);
            } catch (JsonSyntaxException jse) {
                this.chunkGenSettings = new ChunkGenSettings();
                VoidGen.getVoidGen().getLogger().info("Generator settings \"" + paramIdentifier + "\" syntax is not valid. Using default values:");
            }
        }
        // Posting the currently used chunkGenSettings to console.
        VoidGen.getVoidGen().getLogger().info(gson.toJson(chunkGenSettings));
    }

    @Override
    public ChunkData generateChunkData(World world, Random random, int ChunkX, int ChunkZ, BiomeGrid paramBiomeGrid) {
        ChunkData chunkData = this.createChunkData(world);
        if (Objects.nonNull(this.chunkGenSettings.getBiome())) {
            this.setBiomeGrid(paramBiomeGrid, chunkData);
        }

        this.placeBedrock(chunkData, ChunkX, ChunkZ);
        return chunkData;
    }
}