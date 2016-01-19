package rp.robotics.visualisation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import lejos.geom.Point;
import rp.robotics.localisation.GridPositionDistribution;
import rp.robotics.mapping.RPLineMap;

public class GridPositionDistributionVisualisation extends MapVisualisationComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final float BIGGEST_POINT_RADIUS = 60;

	protected GridPositionDistribution m_gridDistribution;

	public GridPositionDistributionVisualisation(
			GridPositionDistribution _distribution, RPLineMap _lineMap,
			float _scaleFactor) {
		super(_lineMap, _scaleFactor);
		m_gridDistribution = _distribution;
	}

	/**
	 * Set distribution to be visualised. Does not update linemap part.
	 * 
	 * @param _gridDistribution
	 */
	public void setDistribution(GridPositionDistribution _gridDistribution) {
		m_gridDistribution = _gridDistribution;
	}

	@Override
	protected void renderMap(Graphics2D _g2) {
		// render lines first
		super.renderMap(_g2);

		_g2.setStroke(new BasicStroke(1));
		_g2.setPaint(Color.BLUE);

		// then add grid
		for (int x = 0; x < m_gridDistribution.getGridWidth(); x++) {
			for (int y = 0; y < m_gridDistribution.getGridHeight(); y++) {
				if (!m_gridDistribution.isObstructed(x, y)) {
					Point gridPoint = m_gridDistribution.getGridMap()
							.getCoordinatesOfGridPosition(x, y);

					float radius = BIGGEST_POINT_RADIUS
							* m_gridDistribution.getProbability(x, y);
					if (radius > 0) {
						if (radius < 1) {
							radius = 1;
						}
						renderPoint(gridPoint, _g2, (int) radius);
					}
				}
			}
		}

	}
}
