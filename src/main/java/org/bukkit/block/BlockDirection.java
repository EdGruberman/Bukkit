package org.bukkit.block;

/**
 * Sun based orientation (newer coordinate system)
 * @see BlockFace
 */
public enum BlockDirection {
    NORTH(0, 0, -1),
    EAST(1, 0, 0),
    SOUTH(0, 0, 1),
    WEST(-1, 0, 0),
    UP(0, 1, 0),
    DOWN(0, -1, 0),
    NORTH_EAST(NORTH, EAST),
    NORTH_WEST(NORTH, WEST),
    SOUTH_EAST(SOUTH, EAST),
    SOUTH_WEST(SOUTH, WEST),
    WEST_NORTH_WEST(WEST, NORTH_WEST),
    NORTH_NORTH_WEST(NORTH, NORTH_WEST),
    NORTH_NORTH_EAST(NORTH, NORTH_EAST),
    EAST_NORTH_EAST(EAST, NORTH_EAST),
    EAST_SOUTH_EAST(EAST, SOUTH_EAST),
    SOUTH_SOUTH_EAST(SOUTH, SOUTH_EAST),
    SOUTH_SOUTH_WEST(SOUTH, SOUTH_WEST),
    WEST_SOUTH_WEST(WEST, SOUTH_WEST),
    SELF(0, 0, 0);

    private final int modX;
    private final int modY;
    private final int modZ;

    private BlockDirection(final int modX, final int modY, final int modZ) {
        this.modX = modX;
        this.modY = modY;
        this.modZ = modZ;
    }

    private BlockDirection(final BlockDirection dir1, final BlockDirection dir2) {
        this.modX = dir1.getModX() + dir2.getModX();
        this.modY = dir1.getModY() + dir2.getModY();
        this.modZ = dir1.getModZ() + dir2.getModZ();
    }

    /**
     * Get the amount of X-coordinates to modify to get the represented block
     *
     * @return Amount of X-coordinates to modify
     */
    public int getModX() {
        return modX;
    }

    /**
     * Get the amount of Y-coordinates to modify to get the represented block
     *
     * @return Amount of Y-coordinates to modify
     */
    public int getModY() {
        return modY;
    }

    /**
     * Get the amount of Z-coordinates to modify to get the represented block
     *
     * @return Amount of Z-coordinates to modify
     */
    public int getModZ() {
        return modZ;
    }

    public BlockDirection getOpposite() {
        switch (this) {
        case NORTH: return BlockDirection.SOUTH;
        case SOUTH: return BlockDirection.NORTH;
        case EAST: return BlockDirection.WEST;
        case WEST: return BlockDirection.EAST;
        case UP: return BlockDirection.DOWN;
        case DOWN: return BlockDirection.UP;
        case NORTH_EAST: return BlockDirection.SOUTH_WEST;
        case NORTH_WEST: return BlockDirection.SOUTH_EAST;
        case SOUTH_EAST: return BlockDirection.NORTH_WEST;
        case SOUTH_WEST: return BlockDirection.NORTH_EAST;
        case WEST_NORTH_WEST: return BlockDirection.EAST_SOUTH_EAST;
        case NORTH_NORTH_WEST: return BlockDirection.SOUTH_SOUTH_EAST;
        case NORTH_NORTH_EAST: return BlockDirection.SOUTH_SOUTH_WEST;
        case EAST_NORTH_EAST: return BlockDirection.WEST_SOUTH_WEST;
        case EAST_SOUTH_EAST: return BlockDirection.WEST_NORTH_WEST;
        case SOUTH_SOUTH_EAST: return BlockDirection.NORTH_NORTH_WEST;
        case SOUTH_SOUTH_WEST: return BlockDirection.NORTH_NORTH_EAST;
        case WEST_SOUTH_WEST: return BlockDirection.EAST_NORTH_EAST;
        case SELF: return BlockDirection.SELF;
        }
        throw new IllegalStateException("unrecognized BlockDirection");
    }

    /**
     * Returns this direction as the equivalent in the original coordinates system
     *
     * @return equivalent in original coordinate system
     */
    public BlockFace toBlockFace() {
        switch (this) {
            case NORTH: return BlockFace.EAST;
            case EAST: return BlockFace.SOUTH;
            case SOUTH: return BlockFace.WEST;
            case WEST: return BlockFace.NORTH;
            case UP: return BlockFace.UP;
            case DOWN: return BlockFace.DOWN;
            case NORTH_EAST: return BlockFace.SOUTH_EAST;
            case NORTH_WEST: return BlockFace.NORTH_EAST;
            case SOUTH_EAST: return BlockFace.SOUTH_WEST;
            case SOUTH_WEST: return BlockFace.NORTH_WEST;
            case WEST_NORTH_WEST: return BlockFace.NORTH_NORTH_EAST;
            case NORTH_NORTH_WEST: return BlockFace.EAST_NORTH_EAST;
            case NORTH_NORTH_EAST: return BlockFace.EAST_SOUTH_EAST;
            case EAST_NORTH_EAST: return BlockFace.SOUTH_SOUTH_EAST;
            case EAST_SOUTH_EAST: return BlockFace.SOUTH_SOUTH_WEST;
            case SOUTH_SOUTH_EAST: return BlockFace.WEST_SOUTH_WEST;
            case SOUTH_SOUTH_WEST: return BlockFace.WEST_NORTH_WEST;
            case WEST_SOUTH_WEST: return BlockFace.NORTH_NORTH_WEST;
            case SELF: return BlockFace.SELF;
        }
        throw new IllegalStateException("unrecognized BlockDirection");
    }
}